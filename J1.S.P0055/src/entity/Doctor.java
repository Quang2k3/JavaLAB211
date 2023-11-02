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
     * Input doctor information, including code, name, specialization, and
     * availability.
     *
     * @param ld The list of doctors to check for code duplicates.
     * @param action to do "add" to add a new doctor or "update" to update a
     * doctor.
     */
    public void input(List<Doctor> ld, String action) {
        if (action.equalsIgnoreCase("ADD")) {
            boolean isCodeDuplicate;
            do {
                this.code = Validate.getString(
                        "Enter code: ",
                        "Must follow the format."
                        + "\nEnter again: ",
                        Constant.REGEX_ID
                );

                isCodeDuplicate = ld.stream().anyMatch(doctor -> 
                        doctor.getCode().equals(this.code));
                if (isCodeDuplicate) {
                    System.out.println("Code is already in use. "
                            + "Please enter a different code.");
                }
            } while (isCodeDuplicate);
        }

        this.name = Validate.getString(
                "Enter name: ",
                "Must be follow format. "
                + "\nEnter again: ",
                Constant.REGEX_NAME
        );

        this.specialization = Validate.getString(
                "Enter specialization: ",
                "Must be follow format. "
                + "\nEnter again: ",
                Constant.REGEX_SP
        );

        this.availability = Validate.getInt(
                "Enter availability: ",
                "Must be follow format.",
                "Enter again: ",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        );
    }

    /**
     * Display the information of doctor.
     */
    public void display() {
        System.out.printf("%10s| %10s| %10s| %10s|\n",
                code, name, specialization, availability);
    }
}
