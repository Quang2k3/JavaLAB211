package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the length of array
        System.out.println("Enter the number of array:");
        int length = sc.nextInt();
        sc.nextLine();
        
        // Input the value need search
        System.out.println("Enter the value:");
        int search = sc.nextInt();
        
        // Create the function of random
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        
        Arrays.sort(arr);
        
        System.out.print("Sorted array:");
        displayArray(arr);
        
        int foundIndex = binarySearch(arr, search);
        if (foundIndex != -1) {
            System.out.println("\nFound " + search + " at index: " + foundIndex);
        } else {
            System.out.println(search + " not found in the array.");
        }
    }
    
    public static void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {            
            int middle = left + (right - left) / 2;
            
            if (arr[middle] == value) {
                return middle;
            }
            
            if (arr[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}