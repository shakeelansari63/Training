from cv2 import cv2 as cv
import numpy as np

img = cv.imread('images/cat.jpg')

# Display Original
cv.imshow('Original', img)


# Translation (shifting of pixels)
# -x --> Shift left
# -y --> Shift Up
#  x --> Shift Right
#  y --> Shift Down
def translate(img, shiftx, shifty):
    # Translation matrix for image
    translation_matrix = np.float32([[1, 0, shiftx], [0, 1, shifty]])
    img_dimension = (img.shape[1], img.shape[0])

    return cv.warpAffine(img, M=translation_matrix, dsize=img_dimension)


translated = translate(img, -50, 50)
cv.imshow('Translated', translated)


# Rotating the Image
# +angle --> rotate counter clockwise
# -angle --> rotate clockwise
def rotate(img, angle, rotation_point=None):
    # Get height and width of Image
    height, width = img.shape[:2]

    # If Rotation point not provided, rotate along center
    if rotation_point is None:
        rotation_point = (width//2, height//2)

    # Generate Rotation Matrix
    rotation_matrix = cv.getRotationMatrix2D(
        center=rotation_point, angle=angle, scale=1.0)
    dimension = (width, height)

    return cv.warpAffine(img, M=rotation_matrix, dsize=dimension)


# Rotate by 60degree
rotated = rotate(img, 60)
cv.imshow('Rotated', rotated)

# Fliping the image
# Flipcode: 0 - Flip Vertically
#           1 - Flip Horizontally
#          -1 - Flip Both
flipped = cv.flip(img, flipCode=1)
cv.imshow('Flipped', flipped)


cv.waitKey(0)
