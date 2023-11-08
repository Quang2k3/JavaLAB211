package validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {
    
    private static final Scanner SCANNER = new Scanner(System.in);

    public Validate() {
    }
    
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

    public static String checkInputDate(
            String messageInfo, 
            String messageErrorOutOfRange,
            String messageErrorParse
    ) {
        while (true) {            
            try {
                String result = SCANNER.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorOutOfRange);
            } catch (ParseException e) {
                System.out.println(messageErrorParse);
            }
        }
    }
    
    /**
     *Prompt user for input, validate it using a regular expression, and return it.
     * 
     * @param messageInfo  Message displayed for user input.
     * @param messageError Message for invalid input.
     * @param REGEX        Regular expression for validation.
     * @return Validated input matching the specified regular expression.
     */
    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX
    ) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}
