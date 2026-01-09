package ed.java.P021Interface;

import java.awt.Color;

// We have a Cat class but in some instances, we want cat to be able to scratch
// But we cannot inherit from multiple classes, so we use interfaces
public class Cat extends Animal implements Scratcher {

    public Cat(Color color) {
        super(color);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    // And we have to implement the scratch() method from the Scratcher interface
    public void scratch() {
        System.out.println("Scratching...");
    }
}
