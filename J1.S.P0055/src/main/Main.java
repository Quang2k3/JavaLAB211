package main;

import bo.DoctorBO;
import constant.Constant;
import entity.Doctor;
import java.util.List;
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
            int choice = Validate.getInt(
                    "Enter your choices: ",
                    "Number must be integer",
                    "Number of array", 
                    1, 6
            );
            switch (choice) {
                case 1:
                    doctorBO.add();
                    break;
                case 2:
                    String codeUpdate = Validate.getString(
                            "Enter code: ", 
                            "Please input correct format.\n"
                            + "Enter again: ", 
                            Constant.REGEX_ID
                    );
                    doctorBO.update(codeUpdate);
                    break;
                case 3:
                    String codeCheck = Validate.getString(
                            "Enter code: ",
                            "Please input correct format.\n"
                            + "Enter again: ",
                            Constant.REGEX_ID
                    );
                    doctorBO.delete(codeCheck);
                    break;
                case 4:
                    String nameSearch = Validate.getString(
                            "Input name search: ",
                            "Invalid name.\n"
                            + "Please try again: ",
                            Constant.REGEX_NAME
                    );
                    doctorBO.search(nameSearch);
                    List<Doctor> foundDoctors = doctorBO.search(nameSearch);
                    doctorBO.displayListSearch(foundDoctors);
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