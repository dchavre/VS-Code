import tensorflow as tf
from tensorflow import keras

import numpy as np
import matplotlib.pyplot as plt

fashion_mnist = keras.datasets.fashion_mnist # Loads dataset
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data() # Split into testing and training data

# 28px by 28px grayscale images
# 0-255, 0 being white, 255 being black

class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat',
               'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle boot']

# Data Preprocessing:
train_images = train_images / 255.0 
test_images = test_images / 255.0

# Making the model:
model = keras.Sequential([
    keras.layers.Flatten(input_shape=(28, 28)), # input layer (1st); Flatten takes the 28 by 28 shape and flatten it down to 784 pixels
    keras.layers.Dense(128, activation='relu'), # hidden layer (2nd); a dense layer, with 128 nodes (usually you want a little bit less than the nodes in the input layer), and relu is the activation function
    keras.layers.Dense(10, activation='softmax') # output layer (3rd); a dense layer, with 10 nodes, and softmax is the activation function
])

# Compiling the model - Picking the optimizer, loss function, and the metrics
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Fitting (training) model to the training data:
model.fit(train_images, train_labels, epochs = 10)

# Evaluating the model:
test_loss, test_acc = model.evaluate(test_images, test_labels, verbose = 1)
print('Test accuracy:', test_acc)

COLOR = 'white'
plt.rcParams['text.color'] = COLOR
plt.rcParams['axes.labelcolor'] = COLOR

def predict(model, image, correct_label):
    prediction = model.predict(np.array([image]))
    predicted_class = class_names[np.argmax(prediction)]
    
    show_image(image, class_names[correct_label], predicted_class)
    
def show_image(img, label, guess):
    plt.figure()
    plt.imshow(img, cmap=plt.cm.binary)
    plt.title('Expected: ' + label)
    plt.xlabel('Guess: ' + guess)
    plt.grid(False)
    plt.show()
        
def get_number():
    while True:
        num=input('Pick a number: ')
        if num.isdigit():
            num = int(num)
            if 0 <= num <= 1000:
                return int(num)
            else:
                print('An error occurred.')
num = get_number()
image = test_images[num]
label = test_labels[num]
predict(model, image, label)