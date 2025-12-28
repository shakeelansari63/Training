package ed.java.P017Records;

public class Main {

    public static void main(String[] args) {
        // We can use a normat class to store some data like
        PassangerClass[] passangers = new PassangerClass[3];
        passangers[0] = new PassangerClass("John Doe", 30, 'M');
        passangers[1] = new PassangerClass("John Doe", 30, 'M');
        passangers[2] = new PassangerClass("Bob Smith", 40, 'M');

        // This helps us store the data, but we have to do lot of things to work with data
        System.out.println(passangers[0].getName());
        System.out.println(passangers[0].equals(passangers[1]));
        System.out.println(passangers[2]);

        // For example we have tor override equals and hashCode methods to compare objects
        // We have to override toString method to print the data in human readable format
        // And we have to write getters and setters for each field
        // Java Provide Record type to create these boilerplace code for us
        PassangerRecord[] rPassangers = new PassangerRecord[3];
        rPassangers[0] = new PassangerRecord("John Doe", 30, 'M');
        rPassangers[1] = new PassangerRecord("John Doe", 30, 'M');
        rPassangers[2] = new PassangerRecord("Bob Smith", 40, 'M');

        // This helps us store the data, but we have to do lot of things to work with data
        System.out.println(rPassangers[0].name());
        System.out.println(rPassangers[0].equals(rPassangers[1]));
        System.out.println(rPassangers[2]);
    }
}
