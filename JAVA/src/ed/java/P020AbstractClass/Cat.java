package ed.java.P020AbstractClass;

import java.awt.Color;

public class Cat extends Animal {

    public Cat(Color color) {
        super(color);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
