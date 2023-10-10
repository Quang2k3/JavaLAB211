package entity;

import java.util.ArrayList;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor() {
    }

    public Doctor(
            String code,
            String name,
            String specialization,
            int availability
    ) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public static void addDoctor(
            ArrayList<Doctor> ld,
            String infoMessage,
            String errorMessage,
            String nameMessage,
            String specializationMessage,
            String availabilityMessage,
            String checkStatus,
            String doneMessage
    ) {
        System.out.print(infoMessage);
        String code = Validate.checkInputString();
        if (!Validate.checkCodeExist(ld, code)) {
            System.out.println(errorMessage);
            return;
        }
        System.out.print(nameMessage);
        String name = Validate.checkInputString();
        System.out.print(specializationMessage);
        String specialization = Validate.checkInputString();
        System.out.print(availabilityMessage);
        int availability = Validate.checkInputInt();
        if (!Validate.checkDuplicate(ld, code,
                name, specialization, availability)) {
            System.out.println(checkStatus);
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println(doneMessage);
    }
}
