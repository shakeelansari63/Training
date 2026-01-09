package ed.java.P007RelationalOperators;

public class Main {

    public static void main(String[] args) {
        // Relational Operators
        int a = 5;
        int b = 10;

        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // Relational operators does not work with strings as they are reference types
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 != str2: " + (str1 != str2));
        System.out.println("str1 > str2: " + (str1.compareTo(str2) > 0));
        System.out.println("str1 < str2: " + (str1.compareTo(str2) < 0));
        System.out.println("str1 >= str2: " + (str1.compareTo(str2) >= 0));
        System.out.println("str1 <= str2: " + (str1.compareTo(str2) <= 0));
    }
}
