from cv2 import cv2 as cv

img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# Averaging
# For Kernel {window frame}, averaging will calculate average of surrounding pixels and set it to middle pixel
avg = cv.blur(img, ksize=(5, 5))
cv.imshow('Averaging Blur', avg)

# Gausian Blur
# Gaussinag blur also take avegar but it weight the surrounding pixels and take weighted avegar
# Due to this, the gaussian blurr is more subtle
gauss = cv.GaussianBlur(img, ksize=(5, 5), sigmaX=0)
cv.imshow('Gaussian Blur', gauss)

# Median Blur
# Table median of surrounding pixels instead of average
# Here kernel size has to be integer and it automatically convert it to matrix internally
median = cv.medianBlur(img, ksize=5)
cv.imshow('Median Blur', median)

# Bilateral Blur
# Bilateral Blur blurs the image while keeping the edges intact
bilateral = cv.bilateralFilter(img, d=10, sigmaColor=30, sigmaSpace=25)
cv.imshow('Bilateral Blur', bilateral)

cv.waitKey(0)
