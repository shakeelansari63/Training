package ed.java.P011CommandLineArgs;

public class Main {

    public static void main(String[] args) {
        // List How many command line arguments were passed
        System.out.println("Number of command line arguments: " + args.length);

        // Check if any arg passed
        if (args.length == 0) {
            System.out.println("No Arguments");
        }

        // Loop over all args and print them
        for (String arg : args) {
            System.out.println("Command line argument: " + arg);
        }
    }
}
