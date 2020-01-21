import tkinter as tk

# In tkinter everything is widget and first you should create root widget
root_widget = tk.Tk()

# Creating Other widget is 2 step process
# 1. Define Widget
# Instead of packing widget, it can be put in virtual Grid system

# Define Label Widget
label1 = tk.Label(root_widget, text = "Hello, World!")

label2 = tk.Label(root_widget, text = "I am Shakeel Ansari")

## Not put in Grid
label1.grid(row = 0, column = 0)
label2.grid(row = 1, column = 1)

# To show the Widget, call mainLoop method

root_widget.mainloop()