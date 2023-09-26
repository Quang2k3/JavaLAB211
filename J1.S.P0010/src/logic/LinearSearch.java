package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Quang
 */
public class LinearSearch {
    
    private int arr[];

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
    
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
        System.out.println("]");
    }

    /**
     * 
     */
    public void generateRandomIntegerOfArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length + 1);
        }
    }
    
    /**
     * 
     * @param searchValue
     * @return 
     */
    public int[] linearSearch(int searchValue) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                positions.add(i);
            }
        }
        int[] result = new int[positions.size()];
        for (int i = 0; i < positions.size(); i++) {
            result[i] = positions.get(i);
        }
        return result;
    }
    
    /**
     * 
     * @param searchValue 
     */
    public void displayIndexArray(int searchValue) {
        int[] positions = linearSearch(searchValue);
        if (positions.length > 0) {
            System.out.print("Found " + searchValue + " at index: ");
            for (int i = 0; i < positions.length; i++) {
                System.out.print(positions[i]);
                if (i < positions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("NOT FOUND:");
        }
    }
}
