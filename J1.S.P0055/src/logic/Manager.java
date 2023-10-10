package logic;

import entity.Doctor;
import validate.Validate;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public class Manager {

    public static void updateDoctor(ArrayList<Doctor> ld,
            String infoMessage,
            String errorMessage,
            String updateCodeMessage,
            String codeMessage,
            String nameMessage,
            String specializationMessage,
            String availabilityMessage,
            String checkStatus,
            String doneMessage
    ) {
        System.out.print(infoMessage);
        String code = Validate.checkInputString();
        if (Validate.checkCodeExist(ld, code)) {
            System.out.println(errorMessage);
            return;
        }
        System.out.print(codeMessage);
        String codeUpdate = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print(nameMessage);
        String name = Validate.checkInputString();
        System.out.print(specializationMessage);
        String specialization = Validate.checkInputString();
        System.out.print(availabilityMessage);
        int availability = Validate.checkInputInt();
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

    public static void deleteDoctor(
            ArrayList<Doctor> ld, 
            String codeMessage, 
            String errorMessage, 
            String doneMessage
    ) {
        System.out.print(codeMessage);
        String code = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println(errorMessage);
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println(doneMessage);
    }

    public static void searchDoctor(
            ArrayList<Doctor> ld, 
            String nameMessage, 
            String errorMessage
    ) {
        System.out.print(nameMessage);
        String nameSearch = Validate.checkInputString();
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