package entity;

import constant.Constant;
import java.util.Calendar;
import java.util.List;
import validate.Validate;

/**
 *
 * @author Quang
 */
public class Candidate {

    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(
            int id, String firstName,
            String lastName, int birthDAte,
            String address, String phone,
            String email, int type
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDAte;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void input(List<Candidate> list) {
        boolean isCodeDuplicate;
        do {
            this.id = Validate.getInt(
                    "Enter ID: ",
                    "Number value out of range.",
                    "Invalid integer number.",
                    1, Integer.MAX_VALUE
            );
            isCodeDuplicate = list.stream().anyMatch(candidate
                    -> candidate.getId() == (this.id));
            if (isCodeDuplicate) {
                System.out.println("Code is already in use. \n"
                        + "Please enter a different code.");
            }
        } while (isCodeDuplicate);

        this.firstName = Validate.getString(
                "Enter first name: ",
                "Invalid first name.",
                Constant.REGEX_NAME
        );

        this.lastName = Validate.getString(
                "Enter last name: ",
                "Invalid last name: ",
                Constant.REGEX_NAME
        );

        this.birthDate = Validate.getInt(
                "Enter birth date: ",
                "Number value out of range.",
                "Invalid integer number",
                Constant.MIN_YEAR,
                Calendar.getInstance().get(Calendar.YEAR)
        );

        this.address = Validate.getString(
                "Enter address: ",
                "Invalid address.",
                Constant.REGEX_ADDRESS
        );

        this.phone = Validate.getString(
                "Enter phone: ",
                "Invalid phone number",
                Constant.REGEX_PHONE
        );

        this.email = Validate.getString(
                "Enter email: ",
                "Invalid email address.",
                Constant.REGEX_EMAIL
        );
    }

    public void displayFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName
                + " | " + this.birthDate
                + " | " + this.address
                + " | " + this.phone
                + " | " + this.email
                + " | " + this.type;
    }
}
