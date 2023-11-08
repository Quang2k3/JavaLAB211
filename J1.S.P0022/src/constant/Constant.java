package constant;

/**
 *
 * @author Quang
 */
public class Constant {

    public static final String REGEX_NAME = "^[A-Za-z ]+$";
    public static final String REGEX_PHONE = "^[0-9]{10,}$";
    public static final String REGEX_EMAIL = "^([\\w\\-\\.]+)@([\\w\\-\\.]+)\\."
            + "([a-zA-Z]{2,5})$";
    public static final String REGEX_ADDRESS = "[A-Za-z0-9 ,\\-\\./]+$";
    public static final String REGEX_TEXT = "^[A-Za-z0-9 ,\\.]+";
    public static final String REGEX_YES_NO = "[yYnN]";
    public static final String REGEX_YES = "y";

    public static final int MIN_YEAR = 1900;
    public static final int EXPERIENCE_TYPE = 0;
    public static final int FRESHER_TYPE = 1;
    public static final int INTERN_TYPE = 2;
}
