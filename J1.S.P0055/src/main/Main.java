package main;

import entity.Doctor;
import java.util.ArrayList;
import logic.Manager;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        while (true) {
            System.out.println("1. Add doctor");
            System.out.println("2. Update doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");
            System.out.println("5. Exit");
            int choice = Validate.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Doctor.addDoctor(
                            ld, "Enter code: ", "Code exits.", 
                            "Enter name: ", "Enter specialization", 
                            "Enter availabitlity", "Duplicate", "Add successful");
                    break;
                case 2:
                    Manager.updateDoctor(
                            ld, "Enter code: ", "Not found doctor", 
                            "Enter update code: ", "Enter code: ", 
                            "Enter name: ", "Enter specialization: ", 
                            "Enter availability: ", "No change", 
                            "Update successful"
                    );
                    break;
                case 3:
                    Manager.deleteDoctor(
                            ld, "Enter code: ", 
                            "Not found doctor", 
                            "Delete successful."
                    );
                    break;
                case 4:
                    Manager.searchDoctor(ld, "Enter name: ", "List empty.");
                    break;
                case 5:
                    return;
            }
        }
    }
}
