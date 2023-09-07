
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Quang
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of array
        System.out.println("Enter number of array:");
        int length = sc.nextInt();
        
        // Input the value
        System.out.println("Enter search value:");
        int value = sc.nextInt();
        
        // Declare array
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        
        LinearSearch search = new LinearSearch();
        System.out.println("The array: ");
        search.displayArray(arr);
        
        int foundIndex = search.linearSearch(arr, value);
        System.out.println("\nFound " + value + " at index: " + foundIndex);
    }
}
