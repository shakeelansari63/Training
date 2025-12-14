package ed.java.p002.VariablesAndConstants;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Premitive Data Types
        // Whole Number Types
        byte b = 10; // 1 Byte
        short s = 100; // 2 Bytes
        int i = 1000; // 4 Bytes
        long l = 10000L; // 8 Bytes

        // Floating Point Types
        float f = 10.5f; // 4 Bytes
        double d = 10.5; // 8 Bytes

        // Character Type
        char c = 'A'; // 2 Bytes

        // Boolean Type
        boolean bool = true; // true or false

        // Reference Data Types
        String str = "Hello, World!";
        Date now = new Date();

        // Print
        System.out.println("Byte: " + b);
        System.out.println("Short: " + s);
        System.out.println("Integer: " + i);
        System.out.println("Long: " + l);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);
        System.out.println("Character: " + c);
        System.out.println("Boolean: " + bool);
        System.out.println("String: " + str);
        System.out.println("Date: " + now);

        // Constants in java are declared with final
        final double PI = 3.14159265358979323846;
        System.out.println("PI: " + PI);
    }
}
