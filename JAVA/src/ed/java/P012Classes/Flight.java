package ed.java.P012Classes;

class Flight {

    // There is internal state or members
    int seat = 100;
    int passangers;

    // This is a default class constructor
    // It will be added automatically by Java if we don't have any other constructor
    public Flight() {}

    // We can have more constructors in this class
    // This is a parameterized class constructor
    public Flight(int seat) {
        this.seat = seat;
    }

    // We can chain constructors using this keyword
    public Flight(int seat, int passangers) {
        // Call constructor with 1 parameter
        this(seat);
        // Set other values
        this.passangers = passangers;
    }

    // These are some class methods
    void bookSeat() {
        if (passangers < seat) {
            passangers++;
        }
    }

    void cancelBooking() {
        if (passangers > 0) {
            passangers--;
        }
    }

    void printStatus() {
        System.out.println("Seats available: " + (seat - passangers));
        System.out.println("Passengers: " + passangers);
    }
}
