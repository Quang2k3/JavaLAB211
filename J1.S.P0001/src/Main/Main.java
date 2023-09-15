package Main;

import Logic.BubbleSort;
import static Validate.Validate.getInt;

/**
 *
 * @author Quang
 */
public class Main {
    
    public static void main(String[] args) {
        
        int numberOfArray = getInt("Enter number of array: ", 
                "Number must be integer", "Number of array", 0, Integer.MAX_VALUE);
        BubbleSort sort = new BubbleSort(numberOfArray);
        sort.generateRandomIntegerOfArray();
        System.out.println("Unsorted:");
        sort.displayArray();
        System.out.println("Sorted:");
        sort.bubbleSort(false);
        sort.displayArray();
    }
}
