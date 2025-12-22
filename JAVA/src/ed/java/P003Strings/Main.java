package ed.java.P003Strings;

public class Main {

    public static void main(String[] args) {
        // Strings are ref type in java
        String str1 = "Hello";
        String str2 = "World";

        // Concatenate strings using the '+' operator
        String str3 = str1 + " " + str2;
        System.out.println("String: " + str3);

        // We can trim Strings using the trim() method
        String str4 = "   Hello World !!  ";
        System.out.println("Trimmed String: " + str4.trim());

        // We can convert Strings to uppercase using the toUpperCase() method
        System.out.println("Uppercase String: " + str3.toUpperCase());

        // We can convert Strings to lowercase using the toLowerCase() method
        System.out.println("Lowercase String: " + str3.toLowerCase());

        // We can replace string in another string with some other string
        System.out.println(
            "Replaced String: " + str3.replace("World", "Universe")
        );

        // We have some escape sequences in Java
        System.out.println("Escape Sequences for double quotes: \"Hey\"");
        System.out.println("Escape Sequences for backslash: C:\\Windows\\");
        System.out.println(
            "Escape Sequences for newline and tab: \n\tHello\tWorld"
        );

        // Strings are immutable in Java so if you append anything, it creates new string and change the reference of the variable
        // If you want to append something to a string, you can use the StringBuilder class
        StringBuilder sb = new StringBuilder(str3);
        sb.append(" ");
        sb.append("!!");
        System.out.println("Appended String: " + sb.toString());
    }
}
