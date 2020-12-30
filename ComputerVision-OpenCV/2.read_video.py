from cv2 import cv2 as cv

# Read Video with Video Capture
capture = cv.VideoCapture(0) # 0 for Web Cam and file path for video file

# Read read frame by frame in a loop
while True:
    # Read Frame
    is_frame, frame = capture.read()

    # If Frame exist then show frame in window
    if is_frame:
        cv.imshow('Cam', frame)

        # Close if d is pressed
        if cv.waitKey(20) & 0xFF == ord('d'):
            break

# Release Capture
capture.release()

# Close all Windows
cv.destroyAllWindows()