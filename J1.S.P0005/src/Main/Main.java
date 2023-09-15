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
        System.out.print("Unsorted array: ");
        sort.displayArray();
        sort.sort(true);
        System.out.print("Sorted array: ");
        sort.displayArray();

    }
}
