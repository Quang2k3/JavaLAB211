package validate;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {
    
    private static final Scanner SCANNER = new Scanner(System.in);

    public Validate() {
    }
    
    public static int checkIntLimit(int min, int max) {
        while (true) {            
            try {
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Re-input");
            }
        }
    }
    
    public static String checkInputDate() {
        while (true) {            
            try {
                String result = SCANNER.nextLine().trim();
                
            } catch (Exception e) {
            }
        }
    }
}
