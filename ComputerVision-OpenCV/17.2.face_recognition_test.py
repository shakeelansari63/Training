# The model saved in part 1 will be tested in part 2 here
from cv2 import cv2 as cv
import os
import numpy as np
import csv


def test_face_recog(test_img):
    # Load the model, feature and labels saved in previous step
    # Model
    face_recognizer = cv.face.LBPHFaceRecognizer_create()
    face_recognizer.read('face_recognition_model/trained_faces.yml')
    # Features not needed anymore
    # features = np.load('face_recognition_model/features.npy',
    #                   allow_pickle=True)
    # Labels not needed anymore
    #labels = np.load('face_recognition_model/labels.npy')
    # label Names
    with open('face_recognition_model/label_names.csv', 'r') as lbl_nm:
        csv_reader = csv.reader(lbl_nm)
        label_names = list(csv_reader)[0]

    # Load haar cascade for detecting face in input image
    face_haar = cv.CascadeClassifier('haar_frontface.xml')

    # Read input image and convert to gray scale
    img = cv.imread(test_img)
    gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

    # Detect face in input gray image
    face_rect = face_haar.detectMultiScale(gray,
                                           scaleFactor=1.1,
                                           minNeighbors=4)

    # Loop on detected face for recognition
    for x, y, w, h in face_rect:
        face_roi = gray[y:y+h, x:x+w]

        # Predict face label from regiion of interest
        label, confidence = face_recognizer.predict(face_roi)

        # Extract label name from label
        name = label_names[label]

        print('Predicted as {} with confidence of {}%'.format(name, confidence))

        # Display Text on Image
        cv.putText(img, '{}% match for {}'.format(confidence, name),
                   (x, y+h+20), fontFace=cv.FONT_HERSHEY_COMPLEX_SMALL,
                   fontScale=1.0, color=(255, 255, 0), thickness=1)
        cv.rectangle(img, (x, y), (x+w, y+h), (0, 255, 0), 2)

    # Show Image
    cv.imshow('Recognised', img)

    cv.waitKey(0)


if __name__ == '__main__':
    test_face_recog('test_celebs/000001.jpg')
