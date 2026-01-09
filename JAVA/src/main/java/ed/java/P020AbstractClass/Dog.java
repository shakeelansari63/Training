package ed.java.P020AbstractClass;

import java.awt.Color;

public class Dog extends Animal {

    public Dog(Color color) {
        super(color);
    }

    // We have to provide an implementation for the abstract method makeSound()
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
