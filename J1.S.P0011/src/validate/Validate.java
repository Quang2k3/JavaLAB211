package validate;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private static Scanner SCANNER = new Scanner(System.in);

    /**
     * Returns check integer limit from the keyboard.
     *
     * @param errorMessageOutOfRange Numeric value out of range.
     * @param errorMessageInvalid Invalid integer number.
     * @param min minimum limit value
     * @param max maximum limit value
     * @return the integer value
     */
    public static int getInt(
            String errorMessageOutOfRange,
            String errorMessageInvalid,
            int min, int max
    ) {
        do {
            try {
                int result = Integer.parseInt(SCANNER.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
                System.out.println(errorMessageOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(errorMessageInvalid);
            }
        } while (true);
    }

    /**
     * Returns an input string from the keyboard.
     *
     * @param messageInfo  message info
     * @param REGEX        the pattern to test string is valid or not
     * @param messageError message error
     * @return the string value
     */
    public static String getString(
            String messageInfo, 
            String messageError, 
            final String REGEX
    ) {
        do {
            System.out.print(messageInfo);
            String result = SCANNER.nextLine();
            if (result.matches(REGEX)) {
                return result;
            }
            System.out.println(messageError);
        } while (true);
    }
}
