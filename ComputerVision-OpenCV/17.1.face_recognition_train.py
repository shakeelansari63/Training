# We detect celebs face using builtin OpenCV face recognition module
from cv2 import cv2 as cv
import os
import numpy as np
import csv


def train_face_recog(base_path):

    # Create 2 sets Feature and Label
    features = []
    labels = []

    # Load Front Face haar cascade for face detection
    face_haar = cv.CascadeClassifier('haar_frontface.xml')

    # Read all images directories and that will be label translator
    face_labels = []
    for face_dir in os.listdir(base_path):
        face_labels.append(face_dir)

    # Now looping over each image directory and reading image
    for label_idx, face_label in enumerate(face_labels):
        face_dir = os.path.join(base_path, face_label)

        # Now loop over images
        for img_name in os.listdir(face_dir):
            img_path = os.path.join(face_dir, img_name)

            # Read image
            img = cv.imread(img_path)

            # Convert to Gray Scale
            gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

            # Detect face using front face Haar cascade
            face_rect = face_haar.detectMultiScale(gray,
                                                   scaleFactor=1.1,
                                                   minNeighbors=4)

            # Crop region of interest from gray scale image
            for x, y, w, h in face_rect:
                face_roi = gray[y:y+h, x:x+w]

                # Add Face feature i.e. roi and label to feature and labels set
                features.append(face_roi)
                labels.append(label_idx)

    # Convert features and labels to numpy array
    features = np.array(features, dtype='object')
    labels = np.array(labels)

    # Train Face recognition model
    face_recognizer = cv.face.LBPHFaceRecognizer_create()
    face_recognizer.train(features, labels)

    # Return faces and labels as numpy array
    return (face_recognizer, features, labels, face_labels)


if __name__ == '__main__':
    # read directories of pictures and build list of celebs
    base_dir = os.path.abspath('train_celebs/')

    # Train face recognition model
    trained_model, features, labels, label_names = train_face_recog(base_dir)

    # Save the model for future use
    trained_model.save('face_recognition_model/trained_faces.yml')
    # Save fatures and Labels
    np.save('face_recognition_model/features.npy', features)
    np.save('face_recognition_model/labels.npy', labels)
    # Save label names in CSV
    with open('face_recognition_model/label_names.csv', 'w') as lbl_nm:
        csv_writer = csv.writer(lbl_nm)
        csv_writer.writerow(label_names)
