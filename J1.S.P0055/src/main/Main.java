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
                    if (doctorBO.add()) {
                        System.out.println("Doctor added successfully.");
                    } else {
                        System.out.println("Failed to add doctor.");
                    }
                    break;
                case 2:
                    String updateCode = Validate.getString(
                            "Enter code to update: ",
                            "Please input a correct code.\n"
                            + "Enter again: ",
                            Constant.REGEX_ID);
                    if (doctorBO.update(updateCode)) {
                        System.out.println("Doctor updated successfully.");
                    } else {
                        System.out.println("Doctor not found or update failed.");
                    }
                    break;
                case 3:
                    String deleteCode = Validate.getString(
                            "Enter code to delete: ",
                            "Please input a correct code.\n"
                            + "Enter again: ",
                            Constant.REGEX_ID);
                    if (doctorBO.delete(deleteCode)) {
                        System.out.println("Doctor deleted successfully.");
                    } else {
                        System.out.println("Doctor not found or delete failed.");
                    }
                    break;
                case 4:
                    String nameSearch = Validate.getString(
                            "Input name to search: ",
                            "Invalid name.\n"
                            + "Please try again: ",
                            Constant.REGEX_NAME
                    );
                    List<Doctor> foundDoctors = doctorBO.search(nameSearch);
                    if (foundDoctors.isEmpty()) {
                        System.out.println("No doctors found with the given name.");
                    } else {
                        doctorBO.display(foundDoctors);
                    }
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
