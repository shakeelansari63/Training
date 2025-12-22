package ed.java.P012Classes;

class Flight {

    // There is internal state or members
    int seat;
    int passangers;

    // This is class constructor
    Flight() {
        this.seat = 50;
        this.passangers = 0;
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
