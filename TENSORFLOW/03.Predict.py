import tensorflow as tf
from tensorflow import keras
import numpy as np
import matplotlib.pyplot as plt

# Select default dataset form Keras
data = keras.datasets.fashion_mnist

# Split data
(train_imgs, train_labels), (test_imgs, test_labels) = data.load_data()

# Train and test images are actaually matrix of pixel values ranging from 0-255
# these numbers can get huge, so in order to reduce computaion, we can divide the pixel values by 255
# this return value between 0-1 but still retain information
train_imgs = train_imgs / 255.0
test_imgs = test_imgs / 255.0

# Label Names
labels = ['T-shirt', 'Trouser', 'Pullover', 'Dress', 'Coat',
          'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle Boot']

# We use Keras Sequential Model meaning all the layers will be sequencially lined up
model = keras.Sequential([
    # Input layer 28x28 flatten image
    keras.layers.Flatten(input_shape=(28, 28)),
    # Relu Activation funtion on hidden layer with 128 neurons
    keras.layers.Dense(128, activation='relu'),
    # Output later with 10 neurons, one for each label
    keras.layers.Dense(10, activation='softmax')
])

# Compile Model
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy', metrics=['accuracy'])

# Train the Model
model.fit(train_imgs, train_labels, epochs=5)

# Lets predict first 10 images in test set and show output
prediction = model.predict([test_imgs[:9]])

for i in range(9):
    plt.imshow(test_imgs[i], cmap=plt.cm.binary)
    plt.xlabel('Actual: {}'.format(labels[test_labels[i]]))
    plt.title('Prediction: {}'.format(labels[np.argmax(prediction[i])]))

    plt.show()
