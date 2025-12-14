package ed.java.p005.Expressions;

public class Main {

    public static void main(String[] args) {
        // Java support arithmetic expressions
        // Addition
        int result_sum = 5 + 3;
        System.out.println("Sum Result: " + result_sum);

        // Substraction
        int result_sub = 5 - 3;
        System.out.println("Sub Result: " + result_sub);

        // Multiplication
        int result_mul = 5 * 3;
        System.out.println("Mul Result: " + result_mul);

        // Division
        int result_div = 5 / 3;
        System.out.println("Div Result: " + result_div);

        // Floating point Division
        double result_div_float = (double) 5 / 3;
        System.out.println("Div Float Result: " + result_div_float);

        // Modulus
        int result_mod = 5 % 3;
        System.out.println("Modulus Result: " + result_mod);

        // Post increment first gives value and then increment
        int x = 1;
        int y = x++;
        System.out.println("Post Increment Operation:: x: " + x + ", y: " + y);

        // Pre increment first increment and then gives value
        x = 1;
        y = ++x;
        System.out.println("Pre Increment Operation:: x: " + x + ", y: " + y);

        // Post decrement first gives value and then decrement
        x = 2;
        y = x--;
        System.out.println("Post Decrement Operation:: x: " + x + ", y: " + y);

        // Pre decrement first decrement and then gives value
        x = 2;
        y = --x;
        System.out.println("Pre Decrement Operation:: x: " + x + ", y: " + y);
    }
}
