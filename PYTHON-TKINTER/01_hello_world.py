import tkinter as tk

# In tkinter everything is widget and first you should create root widget
root_widget = tk.Tk()

# Creating Other widget is 2 step process
# 1. Define Widget
# Pack in the Root widget

# Define Label Widget
label = tk.Label(root_widget, text = "Hello, World!")
label.pack()

# To show the Widget, call mainLoop method

root_widget.mainloop()