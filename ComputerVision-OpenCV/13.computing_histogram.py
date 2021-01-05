# Histogram allow to visualize pixel intensity in an image
from cv2 import cv2 as cv
import matplotlib
from matplotlib import pyplot as plt
import numpy as np

# Use Tk in Matplotlib to avoid conflict with opencv XCB and system XCB
matplotlib.use('TkCairo')


def display_histogram(hist_item, title):
    plt.figure()
    plt.title(title)
    plt.xlabel('Bins')
    plt.ylabel('# of Pixels')
    plt.plot(hist_item)
    plt.xlim([0, 256])


img = cv.imread('images/cat.jpg')
cv.imshow('Original', img)

# Step 1 : Convert to Gray Scale for gray Histogram
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

# Step 2 : Calculate Histogram
# Images is list so we pass image in list
# Channel for each image is list again
# HistSize is number of bins
gray_histogram = cv.calcHist(
    [gray], channels=[0], mask=None, histSize=[256], ranges=[0, 256])


# We can also create mask and use mask to calculate histogram of image which is masked
blank = np.zeros(img.shape[:2], dtype='uint8')
circle = cv.circle(
    blank, (img.shape[0]//2, img.shape[1]//2), radius=100, color=255, thickness=-1)

mask = cv.bitwise_and(gray, gray, mask=circle)
cv.imshow('Masked', mask)

gray_histogram_with_mask = cv.calcHist(
    [gray], channels=[0], mask=mask, histSize=[256], ranges=[0, 256])

# Showing Histogram for Color Image
colors = ['b', 'g', 'r']
plt.figure()
for i, color in enumerate(colors):
    color_hist = cv.calcHist([img], [i], None, [256], [0, 256])
    plt.plot(color_hist, color=color)
    plt.title('Color Histogram')
    plt.xlim([0, 256])

# Calling CV.wait before plottting MatplotLib
cv.waitKey(0)

# Display Matplotlib Plots
display_histogram(gray_histogram_with_mask, 'GrayScale Histogram with Mask')
display_histogram(gray_histogram, 'Gray Scale Histogram w/o mask')
plt.show()
