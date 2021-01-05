# Thresholding is technique to convert image to binary
# user provide a threshold value and image is binarised using that
from cv2 import cv2 as cv

img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# Threshold function take a Gray Sale image, so convert image to gray
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

# Simple Thresholding
# Values greater that thresh will be set to maxval and rest to 0
threshold_val, thresh = cv.threshold(
    gray, thresh=150, maxval=255, type=cv.THRESH_BINARY)

cv.imshow('Simple Thresholded Image', thresh)

# Simple Imverse Thresholding
# Values lesser that thresh will be set to maxval and rest to 0
threshold_val, thresh_inv = cv.threshold(
    gray, thresh=150, maxval=255, type=cv.THRESH_BINARY_INV)

cv.imshow('Simple Inverse Thresholded Image', thresh_inv)

# Adaptive threshold
# This method does not take any user input, instead for provided kernel size it calculate mean
# and use that as threshold for that kernel.
adaptive_thresh = cv.adaptiveThreshold(
    gray, maxValue=255, adaptiveMethod=cv.ADAPTIVE_THRESH_MEAN_C,
    thresholdType=cv.THRESH_BINARY, blockSize=15, C=3)

cv.imshow('Adaptive Thresholded Image', adaptive_thresh)

cv.waitKey(0)
