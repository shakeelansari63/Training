# Contours are boundies of object
# For physical eyes, contours may look simila
# But mathematically they are different from edges
from cv2 import cv2 as cv
import numpy as np

img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# Blank images for visualization of contour
canny_edge_contour = np.zeros(img.shape, dtype='uint8')
threshold_contour = np.zeros(img.shape, dtype='uint8')

# Step 1 : Convert Image to Grayscale
gray = cv.cvtColor(img, code=cv.COLOR_BGR2GRAY)

# Step 2 : Blur Image
blur = cv.GaussianBlur(gray, ksize=(3, 3), sigmaX=cv.BORDER_DEFAULT)

# Step 3 : Identify Edges
edges = cv.Canny(blur, threshold1=125, threshold2=175)
cv.imshow('Edges', edges)
# Find Contours
# Modes: RETR_LIST --> Returns List of all contours
#        RETR_TREE --> Return hierarchy of contours
#        RETR_EXTERNAL --> Return external contours only
#
# Contour Approximation Methods:
#      CHAIN_APPROX_NONE --> Return contour as is
#      CHAIN_APPROX_SIMPLE --> Compress contours

# Step 4: Find contours
contours, hierarchy = cv.findContours(
    edges, mode=cv.RETR_LIST, method=cv.CHAIN_APPROX_NONE)

# See how manu contours exist
print(f'Number of contours from Blur and Canny Edge: {len(contours)}')

# visualize Contours with canny edges
# contourIdx --> -1 shows all contours
cv.drawContours(canny_edge_contour, contours,
                contourIdx=-1, thickness=1, color=(0, 0, 255))
cv.imshow('Contours with canny edge technique', canny_edge_contour)

# We also calculate Threshold and then find contours
# Step 2 : Threshold
ret, thresh = cv.threshold(gray, thresh=100, maxval=255, type=cv.THRESH_BINARY)
cv.imshow('Threshold', thresh)

# Step 3 : Find Contours
contours, hierarchy = cv.findContours(
    thresh, mode=cv.RETR_LIST, method=cv.CHAIN_APPROX_NONE)

# See how manu contours exist
print(f'Number of contours from Threshold: {len(contours)}')

# Visualize contours with threshold technique
cv.drawContours(threshold_contour, contours,
                contourIdx=-1, thickness=1, color=(0, 0, 255))
cv.imshow('Contours with threshold technique', threshold_contour)

cv.waitKey(0)
