# Import Computer Vision
from cv2 import cv2 as cv

# Read Image with imread
img = cv.imread('images/daisy.jpg')

# Display image in seperate window
cv.imshow('Daisy', img) # First is Window name and second is pixel matrix

# Wait for key press and close on key press
cv.waitKey(0)