package ed.java.P018Inheritance;

// We have a pasanger class which has some information about the passenger.
class Passanger {

    private String name;
    private int age;
    private char gender;
    private boolean boarded = false;

    public Passanger(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public boolean isBoarded() {
        return boarded;
    }

    public void board() {
        boarded = true;
        System.out.println("Passenger " + name + " boarded");
    }
}
