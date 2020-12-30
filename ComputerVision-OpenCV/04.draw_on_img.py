from cv2 import cv2 as cv
import numpy as np

# Read File if you want to draw on image file
# img = cv.imread('images/daisy.jpg')

# Create a blank image with all zeros
# Matrix of 500x500 uint8 datatype is for image
# 3 in shape (500, 500, 3) is number of colour channel i.e. BGR
blank = np.zeros((300, 300, 3), dtype='uint8')

# Show blank image
cv.imshow('Blank Image', blank)

# Color whole image to green
blank[:] = 0, 255, 0  # Set all colours to 0,255,0 i.e. Green colour
cv.imshow('Green Image', blank)

# Create part of image
blank[:] = 0, 0, 0  # Set it back to black
blank[100:150, 150:200] = 0, 0, 255
cv.imshow('Red Box Image', blank)

# Draw Line
blank[:] = 0, 0, 0  # Set it back to black
cv.line(blank, pt1=(50, 50), pt2=(250, 250),
        color=(0, 255, 0), thickness=2)
cv.imshow('Green line Image', blank)

# Draw Rectangle on Image
blank[:] = 0, 0, 0  # Set it back to black
cv.rectangle(blank, pt1=(50, 50), pt2=(250, 250),
             color=(255, 0, 0), thickness=2)
cv.imshow('Blue rectangle Image', blank)

# Draw Circle on Image
blank[:] = 0, 0, 0  # Set it back to black
cv.circle(blank, center=(150, 150), radius=60, color=(0, 0, 255), thickness=2)
cv.imshow('Red circle Image', blank)

# Text on Image
blank[:] = 0, 0, 0  # Set it back to black
cv.putText(blank, text="Hello", org=(50, 50), fontFace=cv.FONT_HERSHEY_TRIPLEX,
           fontScale=1.0, color=(255, 255, 0), thickness=2)
cv.imshow('Text Image', blank)

cv.waitKey(0)
