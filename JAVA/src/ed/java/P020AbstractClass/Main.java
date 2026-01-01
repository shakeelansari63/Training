package ed.java.P020AbstractClass;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(Color.BLACK);
        Dog dog = new Dog(Color.WHITE);

        cat.makeSound();
        dog.makeSound();

        System.out.println("Cat: " + cat.getColor());
        System.out.println("Dog: " + dog.getColor());
    }
}
