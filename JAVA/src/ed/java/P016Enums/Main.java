package ed.java.P016Enums;

public class Main {

    public static void main(String[] args) {
        // Enums provide a way to define a set of named constants.
        SimpleFlightCrew[] crew = SimpleFlightCrew.values();
        for (SimpleFlightCrew member : crew) {
            System.out.println(member);
        }

        // The values of each enum constant can be accessed using dot notation.
        System.out.println(SimpleFlightCrew.FLIGHT_ATTENDANT);

        // Enums can also be used in switch statements.
        SimpleFlightCrew sMember = SimpleFlightCrew.FLIGHT_ATTENDANT;
        switch (sMember) {
            case FLIGHT_ATTENDANT:
                System.out.println("Flight attendant");
                break;
            case SECURITY_OFFICER:
                System.out.println("Security officer");
                break;
            case COPILOT:
                System.out.println("Copilot");
                break;
            case PILOT:
                System.out.println("Pilot");
                break;
        }

        // Enums objects can be used to access the methods
        AdvancedFlightCrew[] advancedCrew = AdvancedFlightCrew.values();
        for (AdvancedFlightCrew member : advancedCrew) {
            System.out.println(member + " : " + member.getTitle());
        }
    }
}
