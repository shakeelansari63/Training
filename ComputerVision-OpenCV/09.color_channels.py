from cv2 import cv2 as cv
import numpy as np

img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# Images are build of 3 channels (Blue, Green and Red)
# and they can be split to visualize individually
b, g, r = cv.split(img)

# The Splitted channels can be seen individually
# But they will show as gray Scale, as they do not have color channle
# The whiter area will have higher concentration of color
# whereas the darger are will be lesse concentration
cv.imshow('Blue Channel', b)
cv.imshow('Green Channel', g)
cv.imshow('Red Channel', r)

# They can also be visualised in colors by blending with blank image in correct order of shape
blank = np.zeros(img.shape[:2], dtype='uint8')
blue = cv.merge([b, blank, blank])
green = cv.merge([blank, g, blank])
red = cv.merge([blank, blank, r])
cv.imshow('Blue', blue)
cv.imshow('Green', green)
cv.imshow('Red', red)

# And Original Image can also be re-constructed by merging 3 channels
reconstructed = cv.merge([b, g, r])
cv.imshow('Re-Constructed', reconstructed)

cv.waitKey(0)
