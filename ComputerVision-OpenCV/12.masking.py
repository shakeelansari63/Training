from cv2 import cv2 as cv
import numpy as np

img = cv.imread('images/cat.jpg')

# Create a binary mask
blank = np.zeros(img.shape[:2], dtype='uint8')
rect = cv.rectangle(blank.copy(), (30, 30),
                    (img.shape[1] - 30, img.shape[0] - 30), 255, -1)
circ = cv.circle(
    blank.copy(), (img.shape[1]//2, img.shape[0]//2), img.shape[0]//2 - 10, 255, -1)
mask = cv.bitwise_or(rect, circ)
cv.imshow('Mask', mask)

# Masked Image
masked = cv.bitwise_and(img, img, mask=mask)
cv.imshow('Masked Image', masked)

cv.waitKey(0)
