package main;

import logic.MergeSort;
import static validate.Validate.getInt;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort(
                getInt(
                        "Enter number of array: ",
                        "Number must be integer",
                        "Number of array", 0,
                        Integer.MAX_VALUE
                )
        );
        sort.generateRandomArray();
        System.out.print("Unsorted array: ");
        sort.displayArray();
        System.out.println("Sorted array: ");
        sort.sort("ASC");
        sort.displayArray();
        sort.sort("DESC");
        sort.displayArray();
    }
}
