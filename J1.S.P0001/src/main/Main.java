package main;

import logic.BubbleSort;
import static validate.Validate.getInt;
import constant.Constant;

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
        String type_sort1 = "ASC";
        String type_sort2 = "DESC";
        sort.bubbleSort(type_sort1);
        sort.displayArray();
    }
}
