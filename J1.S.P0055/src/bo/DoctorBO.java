package bo;

import entity.Doctor;
import validate.Validate;
import java.util.ArrayList;
import constant.Constant;
import java.util.List;

/**
 *
 * @author Quang
 */
public class DoctorBO {

    public List<Doctor> ld = new ArrayList<>();

    /**
     * Adds a new Doctor to the provided list of Doctors.
     */
    public void addDoctor() {
        Doctor doctor = new Doctor();
        doctor.input(ld, "Code exits.", "Duplicate", "Add successful");
    }

    /**
     * Updates an existing Doctor in the provided list of Doctors.
     *
     * @param errorMessage The error message to display if the operation fails.
     * @param checkStatus  The status message to display if the operation is not
     *                     allowed.
     * @param doneMessage  The success message to display after updating the
     *                     Doctor.
     */
    public void updateDoctor(
            String errorMessage,
            String checkStatus,
            String doneMessage
    ) {
        String code = Validate.checkInputString(
                "Enter code :", "Please format ",
                "Enter again: ", Constant.REGEX_ID
        );
        if (Validate.checkCodeExist(ld, code)) {
            System.out.println(errorMessage);
            return;
        }
        String codeUpdate = Validate.checkInputString(
                "Enter code update :", "Not Empty",
                "Enter again: ", Constant.REGEX_ID
        );
        Doctor doctor = getDoctorByCode(code);
        String name = Validate.checkInputString(
                "Enter name: ",
                "Not empty",
                "Enter again: ",
                Constant.REGEX_NAME
        );
        String specialization = Validate.checkInputString(
                "Input the specialization: ",
                "Not Empty", "Enter again: ",
                Constant.REGEX_SP
        );
        int availability = Validate.checkInputInt(
                "Enter availability: ",
                "Please input a valid integer.",
                "Please input correct format.",
                Constant.REGEX_ONLY_DIGITS
        );
        if (!Validate.checkChangeInfo(doctor, code, name,
                specialization, availability)) {
            System.err.println(checkStatus);
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println(doneMessage);
    }

    /**
     * Deletes a Doctor from the provided list of Doctors.
     *
     * @param errorMessage The error message to display if the operation fails.
     * @param doneMessage  The success message to display after deleting the
     * Doctor.
     */
    public void deleteDoctor(
            String errorMessage,
            String doneMessage
    ) {
        String code = Validate.checkInputString(
                "Enter code: ", "Not Empty\n",
                "Enter again: \n", Constant.REGEX_ID
        );
        Doctor doctor = getDoctorByCode(code);
        if (doctor == null) {
            System.err.println(errorMessage);
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println(doneMessage);
    }

    /**
     * Searches for Doctors by name in the provided list of Doctors.
     *
     * @param errorMessage The error message to display if no Doctors are found.
     */
    public void searchDoctor(String errorMessage) {
        String nameSearch = Validate.checkInputString(
                "Enter name: ",
                "Not empty\n",
                "Enter again: \n",
                Constant.REGEX_NAME
        );
        List<Doctor> listFoundByName = listFoundByName(nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println(errorMessage);
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    /**
     * Retrieves a Doctor by code from the provided list of Doctors.
     *
     * @param code The code of the Doctor to retrieve.
     * @return the Doctor with the specified code, or null if not found.
     */
    public Doctor getDoctorByCode(String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * Finds Doctors by name in the provided list of Doctors.
     *
     * @param name The name to search for.
     * @return a list of Doctors with names containing the specified name.
     */
    public List<Doctor> listFoundByName(String name) {
        List<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    public void display() {
        ld.forEach((Doctor doctor) -> {
            doctor.display();
        });
    }
}
