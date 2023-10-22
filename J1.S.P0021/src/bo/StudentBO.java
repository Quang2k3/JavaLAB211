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

    public void addStudent(List<Student> list) {
        Student student = new Student();
        student.input();
        list.add(student);
    }

    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("No students");
        }

        Collections.sort(students,
                (Student student1, Student student2)
                -> student1.getStName().compareTo(student2.getStName()));

        String name = Validate.getString(
                "Enter name: ",
                "Must be follow format",
                "Enter again: ",
                Constant.REGEX_STUDENT_NAME);

        for (Student student : students) {
            if (student.getStName().contains(name)) {
                if (students.isEmpty()) {
                    student.display();
                } else {
                    System.out.println("No students");
                }
            }
        }
    }

    public void updateOrDelete(int count) {
        if (students.isEmpty()) {
            System.out.println("No students");
        }
        String id = Validate.getString(
                "Enter id: ",
                "Please follow format.",
                "Enter again: ",
                Constant.REGEX_ID
        );
        List<Student> listStudentFindByName = getListStudentsById(id);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not found student.");
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (Validate.checkInputUD("Input U or D")) {
                String idUpdate = Validate.getString(
                        "Enter id update: ",
                        "Please follow format",
                        "Enter again: ",
                        Constant.REGEX_ID
                );
                String nameUpdate = Validate.getString(
                        "Enter name update: ",
                        "Please follow format",
                        "Enter again: ",
                        Constant.REGEX_STUDENT_NAME
                );
                String semesterUpdate = Validate.getString(
                        "Enter semester update: ",
                        "Please follow format",
                        "Enter again: ",
                        Constant.REGEX_SEMESTER
                );
                String courseUpdate = Validate.getString(
                        "Enter course update: ",
                        "Please follow format",
                        "Enter again: ",
                        Constant.REGEX_COURSE_NAME
                );
                if (Validate.checkChangeInfomation(student, id, nameUpdate,
                        semesterUpdate, courseUpdate)) {
                    System.out.println("No change.");
                }
                student.setID(idUpdate);
                student.setStName(nameUpdate);
                student.setSemester(semesterUpdate);
                student.setCourseName(courseUpdate);
                System.err.println("Update success.");
            } else {
                students.remove(student);
                count--;
                System.out.println("Delete success.");
            }
        }
    }

    public Student getStudentByListFound(List<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validate.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    public List<Student> getListStudentsById(String id) {
        List<Student> getListStudentById = new ArrayList<>();
        for (Student student : getListStudentById) {
            if (id.equalsIgnoreCase(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
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
                    if (id.equalsIgnoreCase(student1.getID()) && courseName.equalsIgnoreCase(student1.getCourseName())) {
                        total++;
                    }
                }
                if (Validate.checkReportExist(lr, id, courseName, total)) {
                    lr.add(new Report(student.getStName(), studentName, total));
                }
            }
        }
    }

    public void printReport() {
        for (int i = 0; i < lr.size(); i++) {
            Report report = lr.get(i);
            System.out.printf("%-15s|%-10s|%-5d\n", report.getStudentName(),
                    report.getCourseName(), report.getTotalCourse());
        }
    }
}
