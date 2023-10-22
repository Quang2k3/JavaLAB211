package validate;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {
    
    private final static Scanner SCANNER = new Scanner(System.in);

    public Validate() {
    }
    
    public static int getInt(
            String messageInfo, 
            String messageErrorOutOfRange, 
            String messageErrorInvalidNumber, 
            int min, int max
    ) {
        do {            
            try {
                System.out.println(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    public static double getDouble(
            String messageInfo, 
            String messageErrorOutOfRange, 
            String messageErrorInvalidNumber, 
            double min, double max
    ) {
        do {            
            try {
                System.out.println(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
    
    public static String getString(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            String conditionString
    ) {
        do {
            try {
                System.out.println(messageInfo);
                String texts = SCANNER.nextLine().toUpperCase();
                if (texts.matches(conditionString)) {
                    return texts;
                }
                System.out.println(messageErrorFormat);

            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidString);
            }
        } while (true);
    }
    
    public static boolean checkInputUD(String messageInfo) {
        while (true) {
            System.out.println(messageInfo);
            String result = SCANNER.nextLine();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
}
