package validate;

import entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * Validates an integer input within a specified range.
     *
     * @param min The minimum value allowed.
     * @param max The maximum value allowed.
     * @return the validated integer input.
     */
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(SCANNER.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage "
                        + "[" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Validates a string input using a regular expression pattern.
     *
     * @param messageInfo               The prompt message to display.
     * @param messageErrorFormat        The error message to display if the 
     *                                  input format is invalid.
     * @param messageErrorInvalidString The error message to display if the 
     *                                  input is empty.
     * @param regex                     The regular expression pattern to 
     *                                  validate against.
     * @return the validated string input.
     */
    public static String checkInputString(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            String regex
    ) {
        System.out.println(messageInfo);
        while (true) {
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
            } else if (!result.matches(regex)) {
                System.out.println(messageErrorFormat);
            } else {
                return result;
            }
            System.out.print("Enter again: ");
        }
    }

    /**
     * Validates an integer input using a regular expression pattern.
     *
     * @param messageInfo               The prompt message to display.
     * @param messageErrorFormat        The error message to display if the 
     *                                  input format is invalid.
     * @param messageErrorInvalidString The error message to display if the 
     *                                  input is empty.
     * @param regex_int                 The regular expression pattern for 
     *                                  valid integers.
     * @return the validated integer input.
     */
    public static int checkInputInt(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            String regex_int
    ) {
        System.out.println(messageInfo);
        while (true) {
            String input = SCANNER.nextLine().trim();
            if (input.matches(regex_int)) {
                try {
                    int result = Integer.parseInt(input);
                    return result;
                } catch (NumberFormatException e) {
                    System.out.println(messageErrorFormat);
                }
            } else {
                System.out.println(messageErrorInvalidString);
            }
        }
    }

    /**
     * Checks if a Doctor with a given code already exists in the list of Doctors.
     *
     * @param ld   The list of Doctors to check in.
     * @param code The code to check for existence.
     * @return true if the code does not exist in the list, false if it exists.
     */
    public static boolean checkCodeExist(
            List<Doctor> ld,
            String code
    ) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a Doctor with specific attributes already exists in 
     * the list of Doctors.
     *
     * @param ld             The list of Doctors to check in.
     * @param code           The code to check for existence.
     * @param name           The name to check for existence.
     * @param specialization The specialization to check for existence.
     * @param availability   The availability to check for existence.
     * @return true if no matching Doctor is found, false if a match is found.
     */
    public static boolean checkDuplicate(
            List<Doctor> ld,
            String code,
            String name,
            String specialization,
            int availability
    ) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a Doctor's information has changed.
     *
     * @param doctor         The Doctor object to compare with.
     * @param code           The new code to compare.
     * @param name           The new name to compare.
     * @param specialization The new specialization to compare.
     * @param availability   The new availability to compare.
     * @return true if the information has changed, false if it remains the same.
     */
    public static boolean checkChangeInfo(
            Doctor doctor,
            String code,
            String name,
            String specialization,
            int availability
    ) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}
