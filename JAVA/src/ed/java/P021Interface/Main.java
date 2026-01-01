package ed.java.P021Interface;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(Color.BLACK);
        Dog dog = new Dog(Color.WHITE);

        // Since Dog and Cat both implement the Animal interface, anyone of them can signal the owner
        signalOwner(cat);
        signalOwner(dog);

        // Since Only Dog implement Digger and Protector interface, we can pass Dog object to dig and protect methods
        dig(dog);
        protect(dog);

        // Since Only Cat implement Scratcher interface, we can pass Cat object to scratch method
        scratch(cat);
    }

    // We have a method to signal the owner by making sound
    // And it can be any animal which can make sound, hence we take the Animal class as imput here
    public static void signalOwner(Animal animal) {
        animal.makeSound();
    }

    // There is A digging task and we want anyone who can dig
    // Hence we take the Digger interface as input here
    public static void dig(Digger digger) {
        digger.dig();
    }

    // There is a task to feed the animals and we want anyone who can feed
    // Hence we take the Feeder interface as input here
    public static void scratch(Scratcher scratcher) {
        scratcher.scratch();
    }

    // And there is a task to protect the owner and we want anyone who can protect
    // Hence we take the Protector interface as input here
    public static void protect(Protector protector) {
        protector.protect();
    }
}
