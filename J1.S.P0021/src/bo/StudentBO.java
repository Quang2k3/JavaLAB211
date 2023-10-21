package bo;

import entity.Student;
import java.util.List;
import validate.Validate;
import constant.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Quang
 */
public class StudentBO {

    List<Student> students = new ArrayList<>();

    public boolean addStudent(
            String id,
            String messageInfo,
            String messageError
    ) {
        for (Student student : students) {
            if (student.getID().equalsIgnoreCase(id)) {
                System.out.println(messageInfo);
                System.out.println(messageError);
                return false;
            }
        }

        Student student = new Student();
        student.input();
        students.add(student);
        return true;
    }

    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("No students");
            return;
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getStName().compareTo(student2.getStName());
            }
        });

        String name = Validate.getString(
                "Enter name: ",
                "Must be follow format",
                "Enter again: ",
                Constant.REGEX_STUDENT_NAME
        );

        for (Student student : students) {
            if (student.getStName().contains(name)) {
                student.display();
            }
        }
    }
    
    public void remove(int index) {
        students.remove(index);
    }
}
