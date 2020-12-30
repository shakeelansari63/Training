from cv2 import cv2 as cv

img = cv.imread('images/daisy.jpg')

cv.imshow('Original', img)

# Convert image to gray scale
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)
cv.imshow('Garyscale', gray)

# Blurring the image
# ksize is kernel size & it must be odd number tuple
blur = cv.GaussianBlur(img, ksize=(5, 5), sigmaX=cv.BORDER_DEFAULT)
cv.imshow('Blur', blur)

# Edge cascade / Edge Detection
# There are many edge cascade module but most famous is Canny edge cascade
# Using original image will give far more edges using blur image will reduce edges
canny = cv.Canny(blur, threshold1=125, threshold2=175)
cv.imshow('Canny Edge Cascade', canny)

# Thresholding image
# Image can be converted to binary using thresholding
# We use gray scale image for thresholding
ret, thresh = cv.threshold(gray, thresh=125, maxval=255, type=cv.THRESH_BINARY)
cv.imshow('Threshold', thresh)

# Dilating the image (Adding Pixels to the boundries)
dilated = cv.dilate(canny, kernel=(5, 5), iterations=3)
cv.imshow('Dilated Edges', dilated)

# Eroding the image (removing Pixels from boundries)
eroded = cv.erode(canny, kernel=(3, 3), iterations=1)
cv.imshow('Eroded Edges', eroded)

# Resizing Image
# INTER_AREA is good for scaling down images
# INTER_LINEAR and INTER_CUBIC are good for scaling up
# INTER_CUBIC is slower but generated result is higher quality
resized = cv.resize(img, dsize=(200, 100), interpolation=cv.INTER_CUBIC)
cv.imshow('Resized Image', resized)

# Cropping image
# Image can be cropped by array slicing
cropped = img[50:150, 150:250]
cv.imshow('Cropped Image', cropped)

cv.waitKey(0)
