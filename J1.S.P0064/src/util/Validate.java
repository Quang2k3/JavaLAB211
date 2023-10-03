package util;

import constant.IConstant;
import exception.PhoneNumberMaxLengthException;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Validate() {
    }

    public static String getPhoneNumber(
            String messageInfo,
            String messageErrorInvalid,
            String messageErrorMaxlength,
            final String REGEX
    ) throws NumberFormatException, PhoneNumberMaxLengthException {

        System.out.print(messageInfo);
        String str = SCANNER.nextLine();

        if (str.matches(REGEX)) {
            if (str.length() == IConstant.PHONE_NUMBER_LENGTH) {
                return str;
            } else {
                throw new PhoneNumberMaxLengthException(messageErrorMaxlength);
            }
        } else {
            throw new NumberFormatException(messageErrorInvalid);
        }
    }

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