package validate;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {
    
    /**
     * Don't let anyone instantiate this class.
     */
    public Validate() {}
    
    /**
     * Returns the valid integer value scanner from the input
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorOutOfRange    the message will be printed if the 
     *                                  String parse is out of range
     * @param messageErrorInvalidNumber the message will be printed if the 
     *                                  String does not contain a parable integer
     * @param                           min minimum limit value
     * @param                           max maximum limit value
     * @return the valid integer value scanner from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
