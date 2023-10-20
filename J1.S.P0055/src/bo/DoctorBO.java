package bo;

import entity.Doctor;
import validate.Validate;
import java.util.ArrayList;
import constant.Constant;

/**
 *
 * @author Quang
 */
public class DoctorBO {

    /**
     * Adds a new Doctor to the provided list of Doctors.
     *
     * @param ld           The list of Doctors to add to.
     * @param errorMessage The error message to display if the operation fails.
     * @param checkStatus  The status message to display if the operation is not
     *                     allowed.
     * @param doneMessage  The success message to display after adding the
     *                     Doctor.
     */
    public static void addDoctor(
            ArrayList<Doctor> ld,
            String errorMessage,
            String checkStatus,
            String doneMessage
    ) {
        String code = Validate.checkInputString(
                "Input the code: ",
                "Not Empty",
                "Enter again: ",
                Constant.REGEX_ID
        );
        if (!Validate.checkCodeExist(ld, code)) {
            System.out.println(errorMessage);
            return;
        }
        String name = Validate.checkInputString(
                "Input the name: ",
                "Not Empty",
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
        if (!Validate.checkDuplicate(ld, code,
                name, specialization, availability)) {
            System.out.println(checkStatus);
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println(doneMessage);
    }

    /**
     * Updates an existing Doctor in the provided list of Doctors.
     *
     * @param ld           The list of Doctors to update.
     * @param errorMessage The error message to display if the operation fails.
     * @param checkStatus  The status message to display if the operation 
     *                     is not allowed.
     * @param doneMessage  The success message to display after updating 
     *                     the Doctor.
     */
    public static void updateDoctor(
            ArrayList<Doctor> ld,
            String errorMessage,
            String checkStatus,
            String doneMessage
    ) {
        String code = Validate.checkInputString(
                "Enter code :", "Not Empty",
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
        Doctor doctor = getDoctorByCode(ld, code);
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
     * @param ld           The list of Doctors to delete from.
     * @param errorMessage The error message to display if the operation fails.
     * @param doneMessage  The success message to display after deleting 
     *                     the Doctor.
     */
    public static void deleteDoctor(
            ArrayList<Doctor> ld,
            String errorMessage,
            String doneMessage
    ) {
        String code = Validate.checkInputString(
                "Enter code: ", "Not Empty",
                "Enter again: ", Constant.REGEX_ID
        );
        Doctor doctor = getDoctorByCode(ld, code);
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
     * @param ld           The list of Doctors to search in.
     * @param errorMessage The error message to display if no Doctors are found.
     */
    public static void searchDoctor(
            ArrayList<Doctor> ld,
            String errorMessage
    ) {
        String nameSearch = Validate.checkInputString(
                "Enter name: ",
                "Not empty",
                "Enter again: ",
                Constant.REGEX_NAME
        );
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
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
     * @param ld   The list of Doctors to search in.
     * @param code The code of the Doctor to retrieve.
     * @return the Doctor with the specified code, or null if not found.
     */
    public static Doctor getDoctorByCode(
            ArrayList<Doctor> ld,
            String code
    ) {
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
     * @param ld   The list of Doctors to search in.
     * @param name The name to search for.
     * @return a list of Doctors with names containing the specified name.
     */
    public static ArrayList<Doctor> listFoundByName(
            ArrayList<Doctor> ld,
            String name
    ) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}