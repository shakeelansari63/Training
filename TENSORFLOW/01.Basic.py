import tensorflow as tf
from tensorflow import keras
import numpy as np
import matplotlib.pyplot as plt

# Select default dataset form Keras
data = keras.datasets.fashion_mnist

# Split data
(train_imgs, train_labels), (test_imgs, test_labels) = data.load_data()

# Label Names
labels = ['T-shirt', 'Trouser', 'Pullover', 'Dress', 'Coat',
          'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle Boot']

# See the image
plt.imshow(train_imgs[7])
plt.show()
