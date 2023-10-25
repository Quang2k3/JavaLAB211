package Main;

import java.util.Scanner;
import logic.Fibonacci;


/**
 *
 * @author Quang
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        System.out.println("The " + number + " sequence of Fibonacci: ");
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.display(number);
    }
}
