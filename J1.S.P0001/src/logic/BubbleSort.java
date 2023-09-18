package logic;

import constant.Constant;
import java.util.Random;

/**
 *
 * @author Quang
 */
public class BubbleSort {

    int arr[];

    public BubbleSort(int numberOfArray) {
        arr = new int[numberOfArray];
    }

    public void generateRandomIntegerOfArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length + 1);
        }
    }

    public void bubbleSort(final String SORT_TYPE) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                switch (SORT_TYPE) {
                    case Constant.ASC:
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                        break;

                    case Constant.DESC:
                        if (arr[j] < arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                        break;
                }
            }
        }
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

}
