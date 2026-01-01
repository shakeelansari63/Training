package ed.java.P021Interface;

import java.awt.Color;

// We have a Dog class but in some instances, we want dog to be able to dig and protect owner
// But we cannot inherit from multiple classes, so we use interfaces
public class Dog extends Animal implements Digger, Protector {

    public Dog(Color color) {
        super(color);
    }

    // We have to provide an implementation for the abstract method makeSound()
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    // Since we implement the Digger interface, we need to provide an implementation for the dig() method
    public void dig() {
        System.out.println("Digging...");
    }

    // Since we implement the Protector interface, we need to provide an implementation for the protect() method
    public void protect() {
        System.out.println("Attack the enemy!");
    }
}
