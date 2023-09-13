package Main;

import Validate.Fibonacci;

/**
 *
 * @author Quang
 */
public class Main {
    
    public static void main(String[] args) {
        int n = 45; 
        Fibonacci fibonacci = new Fibonacci(n);
        System.out.println("The " + n + " sequence fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci.calculateFibonacci(i) + ", ");
        }
    }
}
