package main;

import bo.StudentBO;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Main {
    public static void main(String[] args) {
        
        StudentBO studentBO = new StudentBO();
        
        List<Student> ls = new ArrayList<>();
        Validate validation = new Validate();
        ls.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        ls.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        int count = 3;
        
        int choice;
        do {
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            choice = Validate.getInt(
                    "Enter your choice: ", 
                    "Must be 1 to 5.", 
                    "Number is not valid.", 
                    1, 5
            );
            switch (choice) {
                case 1: 
                    studentBO.addStudent(ls);
                    break;
                case 2:
                    studentBO.findAndSort();
                    break;
                case 3:
                    studentBO.updateOrDelete(count);
                    break;
                case 4:
                    studentBO.report();
                case 5:
                    return;
            }
        } while (choice !=5);
        
    }
}
