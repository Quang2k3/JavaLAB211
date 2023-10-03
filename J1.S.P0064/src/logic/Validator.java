package logic;

import constant.IConstant;
import exception.PhoneNumberMaxLengthException;
import util.Validate;
/**
 *
 * @author Quang
 */
public class Validator {

    /**
     * Returns the valid string phone number.
     *
     * @return the valid string phone number
     */
    public String getPhoneNumber() {
        do {
            try {
                return Validate.getPhoneNumber(
                        "Phone number: ",
                        "Phone number must is number",
                        "Phone number must be 10 digits",
                        IConstant.REGEX_NUMBER
                );
            } catch (NumberFormatException | PhoneNumberMaxLengthException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * Returns the valid string email.
     *
     * @return the valid string email
     */
    public String getEmail() {
        return Validate.getString(
                "Email: ",
                "Email must is correct format.",
                IConstant.REGEX_EMAIL
        );
    }

    /**
     * Returns the valid string date format (dd/MM/yyyy).
     *
     * @return the valid string date format (dd/MM/yyyy)
     */
    public String getDate() {
        return Validate.getString(
                "Date: ",
                "Date to correct format (dd/MM/yyyy)",
                IConstant.REGEX_DATE
        );
    }
}
