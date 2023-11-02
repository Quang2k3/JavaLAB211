package bo;

import entity.Student;
import java.util.List;
import validate.Validate;
import constant.Constant;
import java.util.ArrayList;
import java.util.Collections;
import entity.Report;

/**
 *
 * @author Quang
 */
public class StudentBO {

    List<Student> students = new ArrayList<>();
    List<Report> lr = new ArrayList<>();

    public void add() {
        Student student = new Student();
        student.input(students, "ADD");
        students.add(student);
        System.out.println("Student added successfully.");
    }

//    public void findAndSort() {
//        if (students.isEmpty()) {
//            System.out.println("No students");
//        }
//
//        Collections.sort(students,
//                (Student student1, Student student2)
//                -> student1.getStName().compareTo(student2.getStName()));
//
//        String name = Validate.getString(
//                "Enter name: ",
//                "Must be follow format"
//                + "Enter again: ",
//                Constant.REGEX_STUDENT_NAME);
//
//        for (Student student : students) {
//            if (student.getStName().contains(name)) {
//                if (students.isEmpty()) {
//                    student.display();
//                } else {
//                    System.out.println("No students");
//                }
//            }
//        }
//    }
    public void sort() {
        if (!students.isEmpty()) {
            Collections.sort(students, (Student student1, Student student2)
                    -> student1.getStName().compareTo(student2.getStName()));
        }
    }

    public void update(String codeUpdate) {
        Student studentToUpdate = null;
        for (Student student : students) {
            if (codeUpdate.equalsIgnoreCase(student.getID())) {
                studentToUpdate = student;
                break;
            }
        }
        if (studentToUpdate != null) {
            studentToUpdate.input(students, "UPDATE");
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with the entered code not found.");
        }
    }

    public void delete(String code) {
        Student student = getListStudentsById(code);
        if (student == null) {
            System.out.println("Student does nt exist.");
            return;
        } else {
            students.remove(student);
        }
        System.out.println("Doctor deleted succsessfully.");
    }

//    public Student getStudentByListFound(List<Student> listStudentFindByName) {
//        System.out.println("List student found: ");
//        int count = 1;
//        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
//                "semester", "Course Name");
//        for (Student student : listStudentFindByName) {
//            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
//                    student.getStName(), student.getSemester(),
//                    student.getCourseName());
//            count++;
//        }
//        System.out.print("Enter student: ");
//        int choice = Validate.getInt("", "", "", 1, listStudentFindByName.size());
//        return listStudentFindByName.get(choice - 1);
//    }
    public Student getListStudentsById(String id) {
        for (Student student : students) {
            if (student.getID().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public void report() {
        if (students.isEmpty()) {
            System.out.println("List empty.");
        }

        for (int i = 0; i < students.size(); i++) {
            int total = 0;
            for (Student student : students) {
                String id = student.getID();
                String courseName = student.getCourseName();
                String studentName = student.getStName();
                for (Student student1 : students) {
                    if (id.equalsIgnoreCase(student1.getID())
                            && courseName.equalsIgnoreCase(student1.getCourseName())) {
                        total++;
                    }
                }
//                if (Validate.checkDuplicate(lr, id, courseName, total)) {
//                    lr.add(new Report(student.getStName(), studentName, total));
//                }
            }
        }
    }

    public void displayReport() {
        for (int i = 0; i < lr.size(); i++) {
            Report report = lr.get(i);
            System.out.printf("%-15s|%-10s|%-5d\n", report.getStudentName(),
                    report.getCourseName(), report.getTotalCourse());
        }
    }

    public void displaySort() {
        if (students.isEmpty()) {
            System.out.println("No students");
        } else {
            System.out.println("Sorted Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
