package ed.java.P012Classes;

public class Main {

    public static void main(String[] args) {
        // Create an instance of Flight
        // We don't need to import anything here are Fligt is in same package
        // Default constructor will create flight with default 100 seats and 0 passangers
        Flight flight1 = new Flight();

        // We can create flight with custom number of seats
        Flight flight2 = new Flight(200);

        // Or with custom seats and passangers
        Flight flight3 = new Flight(150, 50);

        System.out.println("######### Flight - 1 #########");

        // Print status
        flight1.printStatus();

        // Book a seat
        for (int i = 0; i < 10; i++) {
            flight1.bookSeat();
        }

        // Print status
        flight1.printStatus();

        // Cancel few seats
        for (int i = 0; i < 5; i++) {
            flight1.cancelBooking();
        }

        // Print status again
        flight1.printStatus();

        // Flight 2
        System.out.println("######### Flight - 2 #########");
        flight2.printStatus();

        // Flight 3
        System.out.println("######### Flight - 3 #########");
        flight3.printStatus();

        // We can access static methods to get total flights and average passangers per flight
        Flight.printTotalInfo();
    }
}
