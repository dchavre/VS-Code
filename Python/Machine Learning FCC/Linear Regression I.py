from __future__ import absolute_import, division, print_function, unicode_literals

import numpy as np
import pandas as pd
import matplotlib as plt
import random
from IPython.display import clear_output

from six.moves import urllib

# Replacement:
from tensorflow import feature_column as fc

# Doesn't Work: import tensorflow.compat.feature_column as fc

import tensorflow as tf

dftrain = pd.read_csv('https://storage.googleapis.com/tf-datasets/titanic/train.csv') # Training Data
dfeval = pd.read_csv('https://storage.googleapis.com/tf-datasets/titanic/eval.csv') # Testing Data

y_train = dftrain.pop('survived')
y_eval = dfeval.pop('survived')

print(dftrain.head())
print(dftrain.shape)

# Optional Info For Inference: 

# dftrain.age.hist(bins=20)
# dftrain.sex.value_counts().plot(kind='barh')
# pd.concat([dftrain,y_train], axis=1).groupby('sex').survived.mean().plot(kind='barh').set_xlabel('% Survive')

# Non-numeric data, will later be turned intp an integer value:
CATEGORICAL_COLUMNS = ['sex', 'n_siblings_spouses', 'parch', 'class', 'deck', 'embark_town', 'alone']

# Numeric datae, already as integer values:
NUMERIC_COLUMNS = ['age', 'fare']

feature_columns = []

for feature_name in CATEGORICAL_COLUMNS:
    vocabulary = dftrain[feature_name].unique() # Takes list of all unique values from given feature column
    feature_columns.append(tf.feature_column.categorical_column_with_vocabulary_list(feature_name, vocabulary)) # Creates a column with the feature_name and vocabulary (like a numpy array).

for feature_name in NUMERIC_COLUMNS:
    feature_columns.append(tf.feature_column.numeric_column(feature_name, dtype=tf.float32))

def make_input_fn(data_df, label_df, num_epochs=10, shuffle=True, batch_size=32):
    def input_function(): # Inner function, will be returned
        ds = tf.data.Dataset.from_tensor_slices((dict(data_df), label_df)) # creates tf.data.Dataset object
        if shuffle:
            ds = ds.shuffle(1000) # Randomizes order of data
        ds = ds.batch(batch_size).repeat(num_epochs) # Splits data set into batches of 32 and repeats the process for the num of epochs
        return ds # returns a batch of the dataset
    return input_function # returns a function object for use

train_input_fn = make_input_fn(dftrain, y_train) # Calls the input function that was returned to get a dataset object which can be fed to the model
eval_input_fn = make_input_fn(dfeval, y_eval, num_epochs=1, shuffle=False) # Same thing but for the evaluation, shuffling isn't needed, as it is just a test

linear_est = tf.estimator.LinearClassifier(feature_columns=feature_columns) 

# Training the Model:

linear_est.train(train_input_fn) # Trains the model
result = linear_est.evaluate(eval_input_fn) # # Gets model metrics/stas via testing on the testing data

clear_output() # Clears console output
print(result['accuracy']) # The result variable us simiply a dict of stats about our model

result = list(linear_est.predict(eval_input_fn))

n = random.randint(0, 266)


print(dfeval.loc[n])
print(y_eval.loc[n])
print(result[n]['probabilities'][1])