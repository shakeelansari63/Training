import tkinter as tk

def click_action():
    tk.Label(root_widget, text = "You clicked it and something happened !!!!!")\
        .grid(row = 1, column = 0, columnspan = 2, sticky = tk.W)

# In tkinter everything is widget and first you should create root widget
root_widget = tk.Tk()

# Creating Other widget is 2 step process
# 1. Define Widget
# Instead of packing widget, it can be put in virtual Grid system

# Define Button Widget
button = tk.Button(root_widget, text = "Do Nothing", state = tk.DISABLED, padx = 50, pady = 50)
button.grid(row = 0, column = 0)

button = tk.Button(root_widget, text = "Do Something", padx = 50, pady = 50, command = click_action)
button.grid(row = 0, column = 1)

# To show the Widget, call mainLoop method

root_widget.mainloop()