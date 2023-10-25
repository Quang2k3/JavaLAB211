package entity;

import constant.Constant;
import java.util.List;
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

    /**
     * Input and validate a doctor's information.
     *
     * @param ld The list of doctors to check for duplicates.
     * @param errorMessage The error message when data is invalid.
     * @param checkStatus  The check message when information is a duplicate.
     * @param doneMessage  The success message when a doctor is added to the
     *                     list.
     */
    public void input(
            List<Doctor> ld,
            String errorMessage,
            String checkStatus,
            String doneMessage
    ) {
        this.code = Validate.checkInputString(
                "Enter code: ",
                "Must be follow format",
                "Enter again: ",
                Constant.REGEX_ID
        );
        this.name = Validate.checkInputString(
                "Enter name: ",
                "Must follow format",
                "Enter again: ",
                Constant.REGEX_NAME
        );
        this.specialization = Validate.checkInputString(
                "Enter specialization: ",
                "Must be follow format.",
                "Enter again: ",
                Constant.REGEX_SP
        );
        this.availability = Validate.checkInputInt(
                "Enter availability: ",
                "Must be follow format",
                "Enter again: ",
                Constant.REGEX_ONLY_DIGITS
        );

        if (!Validate.checkDuplicate(ld, code,
                name, specialization, availability)) {
            System.out.println(checkStatus);
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println(doneMessage);
    }

    /**
     * Display the information of doctor
     */
    public void display() {
        System.out.printf("%10s| %10s| %10s| %10s|\n",
                code, name, specialization, availability);
    }
}
