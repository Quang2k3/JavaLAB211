package validate;

import entity.Report;
import entity.Student;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Validate {

    private final static Scanner SCANNER = new Scanner(System.in);

    public Validate() {
    }

    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
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

    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min, double max
    ) {
        do {
            try {
                System.out.println(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
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

    public static boolean checkInputUD(String messageInfo) {
        System.out.println(messageInfo);
        while (true) {
            String result = SCANNER.nextLine();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getID())
                && name.equalsIgnoreCase(student.getStName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
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
    public static Student checkDuplicate(List<Student> ld, String code) {
        for (Student student : ld) {
            if (code.equalsIgnoreCase(student.getID())) {
                return student;
            }
        }
        return null;
    }
}
