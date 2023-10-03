package logic;

import entity.Doctor;
import validate.Validate;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public class Manager {
    public static void addDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        if (!Validate.checkCodeExits(ld, code)) {
            System.out.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        if (!Validate.checkDuplicate(ld, code, name, specialization, availability)) {
            System.out.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful.");
    }
    
    public static void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        if (Validate.checkCodeExits(ld, code)) {
            System.out.println("Not found doctor");
            return;
        }
    }
}
