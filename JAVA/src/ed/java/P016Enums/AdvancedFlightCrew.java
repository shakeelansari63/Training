package ed.java.P016Enums;

public enum AdvancedFlightCrew {
    // The values of enum are actual instances of Enum class which are accessed via Class like Static Members
    // And we can pass parameters to the constructor to initialize the enum values
    FLIGHT_ATTENDANT("Flight Attendant"),
    SECURITY_OFFICER("Security Officer"),
    COPILOT("First Officer"),
    PILOT("Captain");

    // But just like any class enums can also have other features like
    // Members
    private String title;

    // Constructors
    // Here constructor is made private as we don't want to create instances of this enum outside the class
    // It will be auto created for all defined values
    private AdvancedFlightCrew(String title) {
        this.title = title;
    }

    // Methods
    public String getTitle() {
        return title;
    }
}
