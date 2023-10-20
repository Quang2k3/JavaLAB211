package main;

import entity.Doctor;
import java.util.ArrayList;
import bo.DoctorBO;
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
                    DoctorBO.addDoctor(
                            ld, "Code exits.",
                            "Duplicate", "Add successful");
                    break;
                case 2:
                    DoctorBO.updateDoctor(
                            ld, "Not found doctor",
                            "No change",
                            "Update successful"
                    );
                    break;
                case 3:
                    DoctorBO.deleteDoctor(
                            ld, "Not found doctor",
                            "Delete successful."
                    );
                    break;
                case 4:
                    DoctorBO.searchDoctor(ld, "List empty.");
                    break;
                case 5:
                    return;
            }
        }
    }
}
