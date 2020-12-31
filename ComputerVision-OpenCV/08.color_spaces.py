from cv2 import cv2 as cv

img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# BGR to Grayscale
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)
cv.imshow('Gray', gray)

# BGR to HSV (hue Saturation Value)
hsv = cv.cvtColor(img, cv.COLOR_BGR2HSV)
cv.imshow('HSV', hsv)

# BGR to L*A*B
lab = cv.cvtColor(img, cv.COLOR_BGR2LAB)
cv.imshow('LAB', lab)

# BGR to RGB
# Open CV Usually open and display images in BGR format
# But other modules like matplotlib may use RGB format
# So in external applianca, OpenCV image may look inverted.
# For external compatibility, BGR image can be converted to RGB
rgb = cv.cvtColor(img, cv.COLOR_BGR2RGB)
cv.imshow('RGB', rgb)

cv.waitKey(0)
