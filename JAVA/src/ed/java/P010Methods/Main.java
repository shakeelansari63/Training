package ed.java.P010Methods;

public class Main {

    public static void main(String[] args) {
        // Method Invocation
        sayHelloEmpty();

        // Invoke method with parameters
        sayHelloOneParam("John");

        // Invoke method with multiple parameters
        sayHelloTwoParams("John", 30);

        // Method with Return Value
        int result = addNumbers(5, 3);
        System.out.println("Result: " + result);
    }

    // Method wiout parameters
    public static void sayHelloEmpty() {
        System.out.println("Hello!");
    }

    // Method with parameters
    public static void sayHelloOneParam(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method with multiple parameters
    public static void sayHelloTwoParams(String name, int age) {
        System.out.println(
            "Hello, " + name + "! You are " + age + " years old."
        );
    }

    // Method with Return Value
    public static int addNumbers(int a, int b) {
        return a + b;
    }
}
