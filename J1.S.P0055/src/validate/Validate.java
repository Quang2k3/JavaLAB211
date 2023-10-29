package validate;

import entity.Doctor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private final static Scanner SCANNER = new Scanner(System.in);

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
                System.out.println(messageInfo);
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

    /**
     * Validates a string input using a regular expression pattern.
     *
     * @param messageInfo               The prompt message to display.
     * @param messageErrorFormat        The error message to display if the 
     *                                  input format is invalid.
     * @param messageErrorInvalidString The error message to display if the 
     *                                  input is empty.
     * @param REGEX                     The regular expression pattern to 
     *                                  validate against.
     * @return the validated string input.
     */
    public static String getInputString(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            final String REGEX
    ) {
        System.out.println(messageInfo);
        while (true) {
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
            } else if (!result.matches(REGEX)) {
                System.out.println(messageErrorFormat);
            } else {
                return result;
            }
            System.out.print("Enter again: ");
        }
    }

    /**
     * Checks if a Doctor with a given code already exists in the list of Doctors.
     *
     * @param ld   The list of Doctors to check in.
     * @param code The code to check for existence.
     * @return true if the code does not exist in the list, false if it exists.
     */
    public static boolean checkCodeExist(List<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a doctor with the specified code already exists in the list.
     *
     * @param ld   The list of doctors to check for duplicates.
     * @param code The code to check for duplicates.
     * @return true if a doctor with the same code exists, otherwise false.
     */
    public static boolean checkDuplicate(
            List<Doctor> ld,
            String code
    ) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return true;
            }
        }
        return false;
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
