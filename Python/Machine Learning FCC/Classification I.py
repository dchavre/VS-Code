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

