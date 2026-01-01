package ed.java.P018Inheritance;

// VIP passangers also have a meal and rest is same as normal passanger
// Hence instead of repeating the code, we can use inheritance
class VipPassanger extends Passanger {

    private String meal;

    public VipPassanger(String name, int age, char gender, String meal) {
        // We must call the parent class constructor first in child class as there is no default constructor in parent
        super(name, age, gender);
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    // Override the board method to prepare meal before boarding
    @Override
    public void board() {
        System.out.println("Preparing meal " + getMeal() + " for " + getName());
        super.board();
    }
}
