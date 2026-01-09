package ed.java.P014ObjectClass;

public class Main {

    public static void main(String[] args) {
        // One Problem with regular classes is they cannot be compared by default.
        // For example
        OldFlight flight1 = new OldFlight(172);
        OldFlight flight2 = new OldFlight(172);

        System.out.println(flight1 == flight2); // Output: false
        System.out.println(flight1.equals(flight2)); // Output: false

        // The equals method is also false because it compares the references of the objects, not their content by default.
        // To fix this, we need to override the equals method in the Flight class.
        // Lets create new Flight class
        NewFlight nflight1 = new NewFlight(172);
        NewFlight nflight2 = new NewFlight(172);

        System.out.println(nflight1 == nflight2); // Output: false
        System.out.println(nflight1.equals(nflight2)); // Output: true

        // Similarly if we try to print the object we get reference information but not very human readable
        System.out.println(flight1);

        // Object class has a toString method that returns a string representation of the object.
        // We can override this method in our NewFlight class to provide a more human readable output.
        // And System.out.println automatically calls the toString method
        System.out.println(nflight1);
    }
}
