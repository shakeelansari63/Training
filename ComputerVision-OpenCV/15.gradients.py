from cv2 import cv2 as cv
import numpy as np

img = cv.imread('images/daisy.jpg')
cv.imshow('Original', img)

# Convert to Gray Scale
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

# LAPLACIAN Gradients method
lap = cv.Laplacian(gray, ddepth=cv.CV_64F)
# Laplacian method gets +ve and -ve slopes
# But images cannot have -ve pixel, hence we take absolute values
# and convert it into uint8 i.e. image type
lap = np.uint8(np.absolute(lap))
cv.imshow('Laplacian', lap)

# Sobel Gradients method
# Sobel method can be calculated along x axis or y axis
sobelx = cv.Sobel(gray, ddepth=cv.CV_64F, dx=1, dy=0)
sobely = cv.Sobel(gray, ddepth=cv.CV_64F, dx=0, dy=1)
cv.imshow('Sobel X', sobelx)
cv.imshow('Sobel Y', sobely)
combined_sobel = cv.bitwise_not(sobelx, sobely)
cv.imshow('Sobel Combined', combined_sobel)

# Canny Edge Detection
canny = cv.Canny(gray, 125, 175)
cv.imshow('Canny', canny)

cv.waitKey(0)
