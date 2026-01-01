package ed.java.P018Inheritance;

public class Main {

    public static void main(String[] args) {
        // John is a normal passenger
        Passanger john = new Passanger("John", 25, 'M');
        john.board();
        System.out.println(john.isBoarded());

        // But we have some extra info for VIP pasangers
        VipPassanger vip = new VipPassanger(
            "Jane",
            30,
            'F',
            "Tandoori Chicken"
        );

        vip.board();
        System.out.println(vip.isBoarded());
    }
}
