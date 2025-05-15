import java.util.Scanner;

public class AverageCalculator {
    static class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of elements (n): ");
            int n = scanner.nextInt();
            if (n == 0) {
                throw new IllegalArgumentException("Cannot calculate average for zero elements.");
            }
            int[] A = new int[n];
            System.out.println("Enter " + n + " positive integers: ");
            for (int i = 0; i < n; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                String input = scanner.next();
                try {
                    int value = Integer.parseInt(input);
                    if (value < 0) {
                        throw new InvalidNumberException("Negative number entered: " + value);
                    }
                    A[i] = value;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid integer.");
                    i--;
                } catch (InvalidNumberException e) {
                    System.out.println(e.getMessage());
                    i--;
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += A[i];
            }
            double average = (double) sum / n;
            System.out.println("The average is: " + average);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}