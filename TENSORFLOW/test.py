## import Numpy
import numpy as np

# Import Matplotlib
import matplotlib.pyplot as plt
import matplotlib
matplotlib.use('Qt5Agg')

# Generate Numpy x-coordinates with range having step size 1
x = np.arange(-100, 101, 1)

# f(x) is y with function of x
y = x ** 2 + 2*x + 4

# Create Plot
plt.plot(x, y)
plt.show()
