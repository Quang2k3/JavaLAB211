package logic;

/**
 *
 * @author Quang
 */
public class Fibonacci {

    /**
     * Calculates the n Fibonacci number.
     * 
     * @param n the number input to calculate.
     * @return The Fibonacci number at the specified position.
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * Display the Fibonacci sequence up to a given number of terms.
     * 
     * @param number The number of terms to display in the Fibonacci sequence.
     */
    public void display(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(fibonacci(i) + " ,");
        }
    }
}
