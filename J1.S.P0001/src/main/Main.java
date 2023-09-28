package main;

import logic.BubbleSort;
import static validate.Validate.getInt;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {

        int numberOfArray = getInt(
                "Enter number of array: ",
                "Number must be integer",
                "Number of array", 0,
                Integer.MAX_VALUE
        );

        BubbleSort sort = new BubbleSort(numberOfArray);
        sort.generateRandomArray();
        System.out.println("Unsorted:");
        sort.displayArray();
        System.out.println("Sorted:");
        sort.bubbleSort("ASC");
        sort.displayArray();
        sort.bubbleSort("DESC");
        sort.displayArray();
    }
}
