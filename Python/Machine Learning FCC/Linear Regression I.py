from __future__ import absolute_import, division, print_function, unicode_literals

import numpy as np
import pandas as pd
import matplotlib as plt
from IPython.display import clear_output
from six.moves import urllib

# import tensorflow.compat.feature_column as fc

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
        ds = tf.data.Dataset.from_tensor_slices((dict(data_df), label_df)) # creates tf.data.Dataset object with data and its la
        if shuffle:
            ds = ds.shuffle(1000) # Randomizes order of data
        ds = ds.batch(batch_size).repeat(num_epochs) # Splits data set into batches of 32 and repeats the process for the num of epochs
        return ds # returns a batch of the dataset
    return input_function # returns a function object for use

train_input_fn = make_input_fn(dftrain, y_train) #
eval_input_fn = make_input_fn(dfeval, y_eval, num_epochs=1, shuffle=False)

            
