package constant;

/**
 *
 * @author Quang
 */
public class Constant {

    /**
     *  Allows only letters (both uppercase and lowercase).
     */
    public static final String REGEX_NAME = "^[a-zA-Z]{1,}$";

    /**
     * Allows for IDs in the format "HE123456" or "HS123456" where the last 
     * six characters are digits.
     */
    public static final String REGEX_ID = "^(HE|HS)\\d{6}$";

    /**
     * Allows only letters (both uppercase and lowercase).
     */
    public static final String REGEX_SP = "^[A-Za-z]+$";

    /**
     * Regex pattern for matching integers (whole numbers).
     */
    public static final String REGEX_ONLY_DIGITS = "\\d+";
}
