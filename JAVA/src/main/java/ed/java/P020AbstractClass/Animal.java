package ed.java.P020AbstractClass;

import java.awt.Color;

// Lets say we have animal class which can be inherited by actual animals and this class only defined some features
// We don't want anyone to instantiate this class directly, so we make it abstrac
public abstract class Animal {

    private Color color;

    // We have a constructor that takes a color as a parameter
    public Animal(Color color) {
        this.color = color;
    }

    // We have a method to get the color of the animal
    public Color getColor() {
        return color;
    }

    // We have an abstract method that makes the animal make a sound
    // And since every animal makes a different sound, we want to enforce that every subclass implements this method
    // Hence we make this method abstract which will force every subclass to implement it
    public abstract void makeSound();
}
