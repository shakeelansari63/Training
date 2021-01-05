# For face detection we can use HaarCascade which is developed by OpenCV for detecting faces
# Copy Frontal Face HaarCascade from https://github.com/opencv/opencv/blob/master/data/haarcascades/haarcascade_frontalface_default.xml
# to local
from cv2 import cv2 as cv


def detect_face(img, imgname):
    # Convert to Gray Scale
    gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

    # Read Haar Cascade
    haar = cv.CascadeClassifier('haar_frontface.xml')

    # Detect Face
    faces_rectangles = haar.detectMultiScale(
        gray, scaleFactor=1.1, minNeighbors=7)

    # Faces is list, and number of faces detected will be length of list
    print(f'{len(faces_rectangles)} faces detected in image')

    # Faces rectangle has image's co-rdinates and we can loop over it to see it on actual image
    if len(faces_rectangles) > 0:
        for x, y, w, h in faces_rectangles:
            cv.rectangle(img, (x, y), (x+w, y+h), (0, 255, 0), 2)

        # Show image with detected face
        cv.imshow(f'Face Detected {imgname}', img)


man = cv.imread('images/man.jpeg')
lady = cv.imread('images/lady.jpg')
people = cv.imread('images/people.jpg')

#detect_face(man, 'man')
#detect_face(lady, 'lady')
detect_face(people, 'people')

cv.waitKey(0)
