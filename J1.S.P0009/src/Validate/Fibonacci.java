package Validate;

/**
 *
 * @author Quang
 */
public class Fibonacci {

    int result;

    public Fibonacci(int n) {
        result = calculateFibonacci(n);
    }

    public int displayFibonacci() {
        return result;
    }

    public int calculateFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

}
