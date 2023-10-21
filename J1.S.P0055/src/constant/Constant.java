package constant;

/**
 *
 * @author Quang
 */
public class Constant {

    /**
     * Allows only letters (both uppercase and lowercase).
     */
    public static final String REGEX_NAME = "^[a-zA-Z]{1,}$";

    /**
     * Represents an ID format where it starts with "DOC" followed by a space
     * and then a sequence of one or more digits (e.g., "DOC 1").
     */
    public static final String REGEX_ID = "^DOC\\s\\d+$";

    /**
     * Allows only letters (both uppercase and lowercase).
     */
    public static final String REGEX_SP = "^[A-Za-z]+$";

    /**
     * Regex pattern for matching integers (whole numbers).
     */
    public static final String REGEX_ONLY_DIGITS = "\\d+";
}
