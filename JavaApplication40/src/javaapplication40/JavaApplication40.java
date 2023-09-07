package javaapplication40;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class JavaApplication40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(n); 
            } while (randomNumber == 0); // Lặp lại nếu giá trị là 0
            arr[i] = randomNumber;
        }
        System.out.println("Mảng ngẫu nhiên có " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
