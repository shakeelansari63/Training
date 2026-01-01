package ed.java.P019Polymorphism;

public class Main {

    public static void main(String[] args) {
        // Lets say we have a VIP Passenger
        VipPassanger vip = new VipPassanger(
            "Jane",
            30,
            'F',
            "Tandoori Chicken"
        );

        System.out.println(vip.isBoarded());

        // Since VIP passanger is also a type of passanger, we can cast it as normal passanger
        Passanger passanger = (Passanger) vip;

        // Now though we have casted the VIP passanger as a normal passanger
        // In memory it still is Vip Passanger object, but Java doesn't know that
        // This technique of casting child class as parent class is called upcasting
        // Now if we call board method on passanger object, it will call board method of VipPassanger class
        passanger.board();

        // This happened since we have overridden the board method in VipPassanger class
        // So though we tell Java that passanger is normal passanger, it will call board method of VipPassanger class
        // And this runtime binding also called polymorphism
        System.out.println(passanger.isBoarded());

        // We can create multiple types of passangers
        Passanger p2 = new Passanger("John", 25, 'M');

        boardPassanger(p2);
        System.out.println(p2.isBoarded());

        VipPassanger v2 = new VipPassanger("Tom", 30, 'M', "Burger");
        boardPassanger(v2);
        System.out.println(v2.isBoarded());
    }

    // Lets say we have another method which boards the passangers
    // If we have multiple types of passangers, we have to write multiple overrides of that method
    // Instead we can simply write a method which takes Parent class as parameter
    // And then it doesn't matter which subclass of Passanger we pass, it will call board method of that subclass
    public static void boardPassanger(Passanger passanger) {
        passanger.board();
    }
}
