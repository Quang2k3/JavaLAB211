package validate;

import constant.Constant;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {
    
    private static Scanner SCANNER = new Scanner(System.in);

    /**
     * Don't let anyone instantiate this class.
     */
    private Validate() {
    }
    
    /**
     * Returns an input integer from the keyboard.
     *
     * @param messageInfo               Message info
     * @param messageErrorOutOfRange    Numeric out of range
     * @param messageErrorInvalidNumber Number invalid
     * @param min                       Minimum limit value
     * @param max                       Maximum limit value
     * @return the integer value
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
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

    /**
     * Returns an input string from the keyboard.
     *
     * @param messageInfo  Message info
     * @param REGEX        The pattern to test string is valid or not
     * @param messageError Message error
     * @return the string value
     */
    public static String getString(
            String messageInfo, 
            String messageError, 
            final String REGEX
    ) {
        do {
            System.out.println(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
    
    /**
     * Returns continue option.
     *
     * @return true if value input is y or Y, false otherwise.
     */
    public static boolean isContinue(){
        String c = Validate.getString("Do you want to continue (Y/N)?",
                "Only [Y/N]", Constant.REGEX_YES_NO );
        return c.equalsIgnoreCase(Constant.REGEX_YES);
    }
}