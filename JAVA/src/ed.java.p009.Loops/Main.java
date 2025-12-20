package ed.java.p009.Loops;

public class Main {

    public static void main(String[] args) {
        // While Loop
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // Do-While Loop
        int number = 10;
        do {
            System.out.println("Number: " + number);
            number--;
        } while (number > 0);

        // For Loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);
        }

        // For Each loop
        String[] fruits = { "Apple", "Banana", "Cherry" };
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
