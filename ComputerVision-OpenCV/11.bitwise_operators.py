from cv2 import cv2 as cv
import numpy as np

# Lets create blank images and create 2 copies with shapes
blank = np.zeros((400, 400), dtype='uint8')
rect = cv.rectangle(blank.copy(), (30, 30), (370, 370),
                    color=255, thickness=-1)
circ = cv.circle(blank.copy(), (200, 200), 190, color=255, thickness=-1)

# Bitwise AND --> only intersecting areas
b_and = cv.bitwise_and(rect, circ)
cv.imshow('Bitwise AND', b_and)

# Bitwise OR --> intersecting and non intersecting areas
b_or = cv.bitwise_or(rect, circ)
cv.imshow('Bitwise OR', b_or)

# Bitwise XOR --> only non intersecting areas
b_xor = cv.bitwise_xor(rect, circ)
cv.imshow('Bitwise XOR', b_xor)

# Bitwise NOT --> Invrt Binary image
b_not = cv.bitwise_not(rect)
cv.imshow('Bitwise NOT', b_not)

cv.waitKey(0)
