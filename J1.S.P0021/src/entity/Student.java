package entity;

import validate.Validate;
import constant.Constant;
import java.util.List;

/**
 *
 * @author Quang
 */
public class Student {

    private String ID;
    private String stName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(
            String ID,
            String stName,
            String semester,
            String courseName
    ) {
        this.ID = ID;
        this.stName = stName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void input(List<Student> list, String action) {
//        this.ID = Validate.getString(
//                "Enter ID: ",
//                "Must be follow format: ",
//                "Your ID not valid.",
//                Constant.REGEX_ID
//        );
//
//        this.stName = Validate.getString(
//                "Enter your name: ",
//                "Must be follow format: ",
//                "Your name not valid.",
//                Constant.REGEX_STUDENT_NAME
//        );
//
//        this.semester = Validate.getString(
//                "Enter semester: ",
//                "Must be follow format: ",
//                "Your semester not valid.",
//                Constant.REGEX_SEMESTER
//        );
//
//        this.courseName = Validate.getString(
//                "Enter your course name: ",
//                "Must be follow format: ",
//                "Your course name not valid.",
//                Constant.REGEX_COURSE_NAME
//        );

        while (true) {
            if (ID == null || ID.isEmpty()) {
                this.ID = Validate.getString("Enter code: ",
                        "Must follow format.\n"
                        + "Enter again: ",
                        Constant.REGEX_ID
                );
            }

            Student existingStudent = Validate.checkDuplicate(list, ID);

            if (existingStudent != null) {
                if (action.equalsIgnoreCase("UPDATE")) {
                    this.stName = Validate.getString(
                            "Enter your name: ",
                            "Must be follow format. "
                            + "\nEnter again:",
                            Constant.REGEX_STUDENT_NAME
                    );

                    this.semester = Validate.getString(
                            "Enter semester: ",
                            "Must be follow format. "
                            + "\nEnter again: ",
                            Constant.REGEX_SEMESTER
                    );

                    this.courseName = Validate.getString(
                            "Enter course name: ",
                            "Must be follow format. "
                            + "\nEnter again: ",
                            Constant.REGEX_COURSE_NAME
                    );
                    break;
                } else if (action.equalsIgnoreCase("ADD")) {
                    System.out.println("Student with this ID already exists. "
                            + "Please choose a different ID.");
                    this.ID = null;
                }
            } else {
                this.stName = Validate.getString(
                        action.equalsIgnoreCase("update")
                        ? "Enter name update: " : "Enter your name",
                        "Must be follow format. "
                        + "\nEnter again:",
                        Constant.REGEX_STUDENT_NAME
                );
                
                this.semester = Validate.getString(
                        action.equalsIgnoreCase("update")
                        ? "Enter semester update: " : "Enter your semester",
                        "Must be follow format. "
                        + "\nEnter again:",
                        Constant.REGEX_SEMESTER
                );
                
                this.courseName = Validate.getString(
                        action.equalsIgnoreCase("update")
                        ? "Enter course name update: " : "Enter your course name",
                        "Must be follow format. "
                        + "\nEnter again:",
                        Constant.REGEX_COURSE_NAME
                );
                break;
            }
        }
    }

    public void display() {
        System.out.printf("%10s| %10s| %10s|\n", stName, semester, courseName);
    }
}
