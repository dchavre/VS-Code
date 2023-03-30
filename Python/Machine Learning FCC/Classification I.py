from __future__ import absolute_import, division, print_function, unicode_literals

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import random
from IPython.display import clear_output

from six.moves import urllib

# Replacement:
from tensorflow import feature_column as fc

# Doesn't Work: import tensorflow.compat.feature_column as fc

import tensorflow as tf

CSV_COLUMN_NAMES = ['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth', 'Species']
SPECIES = ['Setosa', 'Versicolor', 'Virginica']

train_path = tf.keras.utils.get_file(
    'iris_training.csv', 'https://storage.googleapis.com/download.tensorflow.org/data/iris_training.csv'
)
test_path = tf.keras.utils.get_file(
    'iris_training.csv', 'https://storage.googleapis.com/download.tensorflow.org/data/iris_test.csv'
)

train = pd.read_csv(train_path,names=CSV_COLUMN_NAMES, header=0)
test = pd.read_csv(test_path,names=CSV_COLUMN_NAMES, header=0)

# Use Keras to grab datasets and read them into a pandas dataframe:
train.head()

# Gets rid of Species Column:
train_y = train.pop('Species')
test_y = test.pop('Species')

# With train.shape(), you can determine that there are 120 entries, with 4 columns.

def input_fn(features, labels, training=True, batch_size = 256):
    # Converting inputs into a Dataset:
    dataset = tf.data.Dataset.from_tensor_slices((dict(features), labels))
    
    # Shuffle and repeart if in training mode:
    if training:
        dataset = dataset.shuffle(1000).repeat()

    return dataset.batch(batch_size)

my_feature_columns = []

for key in train.keys(): # train.keys() gives all the columns
    my_feature_columns.append(tf.feature_column.numeric_column(key=key)) # Creates feature columns

# Building a DNN with 2 hidden layers with 30 and 10 hidden nodes each:
classifier = tf.estimator.DNNClassifier(
    feature_columns=my_feature_columns,
    # Two hidden layers of 30 and 10 nodes respectively:
    hidden_units = [30, 10],
    n_classes=3)

classifier.train(
    # Lamba is used to create a one line func, which returns a function to us when it is called:
    # We need to do this because we don't have an interior function to directly call input_fn.
    input_fn = lambda: input_fn(train, train_y, training=True),
    steps=5000) # Steps are like epochs

# While training, it tells you the loss, and you want that number to be as small as possible,
# It also tells you the current step, and global steps/sec
# At the end of the training, it tells you the loss for final step, and the smaller, the better

eval_result = classifier.evaluate(input_fn = lambda: input_fn(test, test_y, training=False)) 

print('\nTest Set Accuracy: {accuracy:0.3f}\n'.format(**eval_result))

def input_fn(features, batch_size=256):
    # Converts the inputs into a Dataset without labels.
    return tf.data.Dataset.from_tensor_slices(dict(features)).batch(batch_size)
features = ['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth']
predict = {}

# Allows users  to input some values:
print('Please type numeric values as prompted.')
for feature in features:
    valid = True
    while valid:
        val = input(feature + ': ')
        if not val.isdigit():valid = False

    predict[feature] = [float(val)]

    predictions = classifier.predict(input_fn=lambda:input_fn(predict))
    for pred_dict in predictions:
        class_id = pred_dict['class_ids'][0]
        probability = pred_dict['probabilities'][class_id]

        print('Prediction is "{}" ({:;1f}%)'.format(
              SPECIES[class_id], 100 * probability))

