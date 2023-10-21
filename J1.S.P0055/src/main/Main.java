package main;

import bo.DoctorBO;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        
        DoctorBO doctorBO = new DoctorBO();
        
        while (true) {
            System.out.println("1. Add doctor");
            System.out.println("2. Update doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");
            System.out.println("5. Display list doctor");
            System.out.println("6. Exits");
            int choice = Validate.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    doctorBO.addDoctor();
                    break;
                case 2:
                    doctorBO.updateDoctor(
                            "Not found doctor",
                            "No change",
                            "Update successful"
                    );
                    break;
                case 3:
                    doctorBO.deleteDoctor(
                            "Not found doctor",
                            "Delete successful."
                    );
                    break;
                case 4:
                    doctorBO.searchDoctor("List empty.");
                    break;
                case 5:
                    doctorBO.display();
                    break;
                case 6: 
                    return;
            }
        }
    }
}
