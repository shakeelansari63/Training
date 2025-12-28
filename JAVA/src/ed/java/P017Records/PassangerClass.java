package ed.java.P017Records;

class PassangerClass {

    private String name;
    private int age;
    private char gender;

    public PassangerClass(String name, int age, char gender) {
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
}
