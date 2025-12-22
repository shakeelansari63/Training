package ed.java.P012Classes;

public class Main {

    public static void main(String[] args) {
        // Create an instance of Flight
        // We don't need to import anything here are Fligt is in same package
        Flight flight = new Flight();

        // Print status
        flight.printStatus();

        // Book a seat
        for (int i = 0; i < 10; i++) {
            flight.bookSeat();
        }

        // Print status
        flight.printStatus();

        // Cancel few seats
        for (int i = 0; i < 5; i++) {
            flight.cancelBooking();
        }

        // Print status again
        flight.printStatus();
    }
}
