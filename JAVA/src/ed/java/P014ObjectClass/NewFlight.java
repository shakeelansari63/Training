package ed.java.P014ObjectClass;

class NewFlight {

    // There is internal state or members
    int seat = 100;
    int passangers;
    int flightNumber;

    // These are static members and only 1 copy is kept for these variables
    static int totalFlights;
    static int totalPassengers;

    // This is a default class constructor
    // It will be added automatically by Java if we don't have any other constructor
    // This method is made private to avoid users from using it directly
    private NewFlight() {
        // We will increment total flights in constructor to track flights
        totalFlights++;
    }

    // Create a constructor with flight number
    public NewFlight(int flightNumber) {
        this();
        this.flightNumber = flightNumber;
    }

    // We can have more constructors in this class
    // This is a parameterized class constructor
    public NewFlight(int flightNumber, int seat) {
        this(flightNumber);
        this.seat = seat;
    }

    // We can chain constructors using this keyword
    public NewFlight(int flightNumber, int seat, int passangers) {
        // Call constructor with 1 parameter
        this(flightNumber, seat);
        // Set other values
        this.passangers = passangers;
        totalPassengers += passangers;
    }

    // We will implement equals method to compare the content of the objects
    @Override
    public boolean equals(Object obj) {
        // The equals method takes an Object as a parameter and returns a boolean value
        // Object is parent class of all classes. So any value can be passed to object
        // Hence we have a check for class type
        if (!(obj instanceof NewFlight)) return false;

        // If they are same references, return true
        if (this == obj) return true;

        // Convert object parameter to NewFlight class
        NewFlight flight = (NewFlight) obj;
        return this.flightNumber == flight.flightNumber;
    }

    // These are some class methods
    void bookSeat() {
        if (passangers < seat) {
            passangers++;
            totalPassengers++;
        }
    }

    // We can have some overloaded methods which have same name but different signatures
    // For example we can book multiple seats
    void bookSeat(int count) {
        if (passangers + count <= seat) {
            passangers += count;
            totalPassengers += count;
        }
    }

    void cancelBooking() {
        if (passangers > 0) {
            passangers--;
            totalPassengers--;
        }
    }

    // And we can also cancel multiple bookings
    void cancelBooking(int count) {
        if (passangers >= count) {
            passangers -= count;
            totalPassengers -= count;
        }
    }

    // We can also override the toString method to provide a more human readable output
    @Override
    public String toString() {
        return (
            "Flight Number: " +
            flightNumber +
            ", Seats Available: " +
            (seat - passangers)
        );
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
