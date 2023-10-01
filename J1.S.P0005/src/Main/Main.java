package Main;

import Logic.MergeSort;
import static Validate.Validate.getInt;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {

        int numberOfArray = getInt("Enter number of array: ",
                "Number must be integer", "Number of array", 0, Integer.MAX_VALUE);
        MergeSort sort = new MergeSort(numberOfArray);
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
