package ed.java.P015WrapperClasses;

public class Main {

    public static void main(String[] args) {
        // Java premitives are simply storage for storing premitive value
        // They are not extensible like Classes are. Thats why Java has Builtin Wrapper classes for these premitives
        // int - Integer
        // double - Double
        // boolean - Boolean
        // char - Character
        // byte - Byte
        // short - Short
        // long - Long
        // float - Float
        // These wrapper classes provides additional functionality like parsing, formatting, and comparison for premitive types
        int a = 10;
        Integer b = 20;
        System.out.println(a);
        System.out.println(b);

        // These Wrapper classes allow assigning value directly like premitives. They are automatically converted to references
        // This is called boxing
        Integer c = a;
        System.out.println(c);

        // The values of these wrapper classes can be unboxed back to premitives
        int d = c;
        System.out.println(d);

        // These Wrapper classes provide some useful methods like
        // Extractig value from string
        int e = Integer.parseInt("123");
        System.out.println(e);
    }
}
