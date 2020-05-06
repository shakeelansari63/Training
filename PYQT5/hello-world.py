import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QLabel
from PyQt5.QtCore import Qt


class HelloWindow(QMainWindow):
    def __init__(self, *args, **kwargs):
        # Create app
        self.app = QApplication(sys.argv)
        
        # Initialize the Super class
        super().__init__(*args, **kwargs)

        # Set Window Title
        self.setWindowTitle("Hello World Program")

        # Display Text
        label = QLabel("Hello World!!!")

        # Set Central label
        label.setAlignment(Qt.AlignCenter)

        # Set Widget in center
        self.setCentralWidget(label)


if __name__ == '__main__':

    # Create Window
    win = HelloWindow()

    # Show Window
    win.show()

    # Execute App
    win.app.exec_()
