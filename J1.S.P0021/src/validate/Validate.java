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

    public static String getString(
            String messageInfo,
            String messageErrorFormat,
            String messageErrorInvalidString,
            String conditionString
    ) {
        do {
            try {
                System.out.println(messageInfo);
                String texts = SCANNER.nextLine().toUpperCase();
                if (texts.matches(conditionString)) {
                    return texts;
                }
                System.out.println(messageErrorFormat);

            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidString);
            }
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

    public static boolean checkReportExist(List<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
