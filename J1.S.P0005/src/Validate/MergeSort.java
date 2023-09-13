package Validate;

import java.util.Random;

/**
 *
 * @author Quang
 */
public class MergeSort {
    int arr[];
    int tempMergArr[];
    int length;
    
    public MergeSort(int length) {
        this.length = length;
        this.arr = new int[length];
        this.tempMergArr = new int [length];
        generateRandomIntegerOfArray();
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
    
    public void sort() {
        doMergeSort(0, length - 1);
    }
    
    public void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                arr[k] = tempMergArr[i];
                i++;
            } else {
                arr[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
