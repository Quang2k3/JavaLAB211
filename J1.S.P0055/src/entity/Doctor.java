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
     * @param isUpdate
     */
    public void input(List<Doctor> ld, boolean isUpdate) {
        while (true) {
            if (code == null || code.isEmpty()) {
                this.code = Validate.getInputString(
                        "Enter code: ",
                        "Must follow format",
                        "Enter again: ",
                        Constant.REGEX_ID
                );
            }

            Doctor existingDoctor = Validate.checkDuplicate(ld, this.code);

            if (existingDoctor != null) {
                if (isUpdate) {
                    this.name = Validate.getInputString(
                            "Enter updated name: ",
                            "Must follow format",
                            "Enter again: ",
                            Constant.REGEX_NAME
                    );

                    this.specialization = Validate.getInputString(
                            "Enter updated specialization: ",
                            "Must follow format.",
                            "Enter again: ",
                            Constant.REGEX_SP
                    );

                    this.availability = Validate.getInt(
                            "Enter updated availability: ",
                            "Please input a valid integer.",
                            "Please input correct format.",
                            Integer.MIN_VALUE,
                            Integer.MAX_VALUE
                    );
                    break;
                } else {
                    System.out.println("Doctor with this code already exists. "
                            + "Please choose a different code.");
                    this.code = null;
                }
            } else {
                this.name = Validate.getInputString(
                        isUpdate ? "Enter updated name: " : "Enter name: ",
                        "Must follow format",
                        "Enter again: ",
                        Constant.REGEX_NAME
                );

                this.specialization = Validate.getInputString(
                        isUpdate ? "Enter updated specialization: " : 
                                "Enter specialization: ",
                        "Must follow format.",
                        "Enter again: ",
                        Constant.REGEX_SP
                );

                this.availability = Validate.getInt(
                        isUpdate ? "Enter updated availability: " : 
                                "Enter availability: ",
                        "Please input a valid integer.",
                        "Please input correct format.",
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE
                );
                break;
            }
        }
    }

    /**
     * Display the information of doctor.
     */
    public void display() {
        System.out.printf("%10s| %10s| %10s| %10s|\n",
                code, name, specialization, availability);
    }
}
