package ed.java.P012Classes;

class Flight {

    // There is internal state or members
    int seat = 100;
    int passangers;

    // These are static members and only 1 copy is kept for these variables
    static int totalFlights;
    static int totalPassengers;

    // This is a default class constructor
    // It will be added automatically by Java if we don't have any other constructor
    public Flight() {
        // We will increment total flights in constructor to track flights
        totalFlights++;
    }

    // We can have more constructors in this class
    // This is a parameterized class constructor
    public Flight(int seat) {
        this();
        this.seat = seat;
    }

    // We can chain constructors using this keyword
    public Flight(int seat, int passangers) {
        // Call constructor with 1 parameter
        this(seat);
        // Set other values
        this.passangers = passangers;
        totalPassengers += passangers;
    }

    // These are some class methods
    void bookSeat() {
        if (passangers < seat) {
            passangers++;
            totalPassengers++;
        }
    }

    void cancelBooking() {
        if (passangers > 0) {
            passangers--;
            totalPassengers--;
        }
    }

    void printStatus() {
        System.out.println("Seats available: " + (seat - passangers));
        System.out.println("Passengers: " + passangers);
    }

    // We can also create static methods to access static members details
    static void printTotalInfo() {
        System.out.println("Total flights: " + totalFlights);
        if (totalFlights > 0) System.out.println(
            "Average passangers per flight: " +
                ((float) totalPassengers / totalFlights)
        );
    }
}
