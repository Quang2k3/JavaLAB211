package Validate;

import java.util.Random;

/**
 *
 * @author Quang
 */
public class LinearSearch {
    int arr[];
    
    public LinearSearch(int numberOfArray) {
        arr = new int[numberOfArray];
    }
    
    public void displayArray() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    
    public void generateRandomIntegerOfArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length + 1);
        }
    }
    
    public int linearSearch(int searchValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }
    
    public void displayIndexOfArray(int searchValue) {
        int indexOfSearch = linearSearch(searchValue);
        
        if (indexOfSearch != -1) {
            System.out.println("Found " + searchValue + " at index: " + indexOfSearch);
        } else {
            System.out.println("NOT FOUND");
        }
    }
}
