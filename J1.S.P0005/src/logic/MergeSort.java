package logic;

import constant.Constant;
import java.util.Random;

/**
 *
 * @author Quang
 */
public class MergeSort {

    private int arr[];
    private int tempMergArr[];
    private int length;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getTempMergArr() {
        return tempMergArr;
    }

    public void setTempMergArr(int[] tempMergArr) {
        this.tempMergArr = tempMergArr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public MergeSort(int length) {
        this.length = length;
        this.arr = new int[length];
        this.tempMergArr = new int[length];
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

    public void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length + 1);
        }
    }

    public void sort(final String SORT_TYPE) {
        doMergeSort(0, length - 1, SORT_TYPE);
    }

    public void doMergeSort(
            int lowerIndex, 
            int higherIndex, 
            final String SORT_TYPE
    ) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle, SORT_TYPE);
            doMergeSort(middle + 1, higherIndex, SORT_TYPE);
            mergeParts(lowerIndex, middle, higherIndex, SORT_TYPE);
        }
    }

    /**
     *
     * @param lowerIndex    
     * @param middle        
     * @param higherIndex   
     * @param check         
     */
    private void mergeParts(
            int lowerIndex, int middle, 
            int higherIndex, 
            final String SORT_TYPE
    ) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            switch (SORT_TYPE) {
                case Constant.ASC:
                    if (tempMergArr[i] <= tempMergArr[j]) {
                        arr[k] = tempMergArr[i];
                        i++;
                    } else {
                        arr[k] = tempMergArr[j];
                        j++;
                    }
                    k++;
                    break;
                case Constant.DESC:
                    if (tempMergArr[i] >= tempMergArr[j]) {
                        arr[k] = tempMergArr[i];
                        i++;
                    } else {
                        arr[k] = tempMergArr[j];
                        j++;
                    }
                    k++;
                    break;
            }
        }
        while (i <= middle) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
