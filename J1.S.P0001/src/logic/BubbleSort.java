package logic;

import constant.Constant;
import java.util.Random;

/**
 *
 * @author Quang
 */
public class BubbleSort {

    private int arr[];

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public BubbleSort(int numberOfArray) {
        arr = new int[numberOfArray];
    }

    /**
     * Generate random of array
     */
    public void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length + 1);
        }
    }

    /**
     * Sorted an array by ascending or descending
     *
     * @param SORT_TYPE using input ASC to be sort ascending or DESC to be sort
     *                  descending
     */
    public void bubbleSort(final String SORT_TYPE) {
        switch (SORT_TYPE) {
            case Constant.ASC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
                break;
            case Constant.DESC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        if (arr[j] < arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
                break;
        }
    }

    /**
     * Display an array
     */
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
}
