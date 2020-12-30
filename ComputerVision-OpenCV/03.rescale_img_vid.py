from cv2 import cv2 as cv


# Method for Rescaling frames
# Works on Photos, Videos and Live Video
def rescale_frame(frame, scale=0.5):
    height = int(frame.shape[0] * scale)  # Calculate new height
    width = int(frame.shape[1] * scale)  # Calculate new width
    dimension = (width, height)  # new Dimension

    return cv.resize(frame, dimension, interpolation=cv.INTER_AREA)


# Method to resize capture resolution
# Works on Live video feed only
def change_resolution(width, height):
    capture.set(3, width)  # 3rd parameter is width
    capture.set(4, height)  # 4th parameter is height


# Read Video with Video Capture
capture = cv.VideoCapture(0)  # 0 for Web Cam and file path for video file

# Read read frame by frame in a loop
while True:
    # Read Frame
    is_frame, frame = capture.read()

    # If Frame exist then show frame in window
    if is_frame:
        rescaled_frame = rescale_frame(frame)
        cv.imshow('Cam', frame)
        cv.imshow('Cam Rescaled', rescaled_frame)

        # Close if d is pressed
        if cv.waitKey(20) & 0xFF == ord('d'):
            break

# Release Capture
capture.release()

# Close all Windows
cv.destroyAllWindows()
