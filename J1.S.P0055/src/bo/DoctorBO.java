package bo;

import entity.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quang
 */
public class DoctorBO {

    private List<Doctor> ld = new ArrayList<>();

    public DoctorBO() {
    }

    public void setLd(List<Doctor> ld) {
        this.ld = ld;
    }

    /**
     * Add a new doctor to the list with user information.
     */
    public void add() {
        Doctor newDoctor = new Doctor();
        newDoctor.input(ld, false); // Pass 'false' to indicate this is an 'add' operation
        ld.add(newDoctor);
        System.out.println("Doctor added successfully.");
    }

    /**
     * Update doctor information by their unique code.
     *
     * @param codeUpdate The code of the doctor to update.
     */
    public void update(String codeUpdate) {
        Doctor doctorToUpdate = null;
        for (Doctor doctor : ld) {
            if (codeUpdate.equalsIgnoreCase(doctor.getCode())) {
                doctorToUpdate = doctor;
                break;
            }
        }
        if (doctorToUpdate != null) {
            doctorToUpdate.input(ld, true); // Pass 'true' to indicate this is an 'update' operation
            System.out.println("Doctor updated successfully");
        } else {
            System.out.println("Doctor with the entered code not found");
        }
    }

    /**
     * Deletes a doctor from the list by their unique code.
     *
     * @param code The unique code of the doctor to delete.
     */
    public void delete(String code) {
        Doctor doctor = getDoctorByCode(code);
        if (doctor == null) {
            System.out.println("Doctor does not exist.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.out.println("Doctor deleted successfully");
    }

    /**
     * Searches for doctors by name and returns a list of matching doctors.
     *
     * @param nameSearch The name to search for.
     * @return A list of doctors whose names contain the specified search term.
     */
    public List<Doctor> search(String nameSearch) {
        List<Doctor> listFoundByName = new ArrayList<>();
        ld.stream().filter((doctor) -> (doctor.getName().contains(nameSearch))).
                forEachOrdered((doctor) -> {
                    listFoundByName.add(doctor);
                });

        return listFoundByName;
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
     * Display list of doctor search
     *
     * @param doctors The list of doctors to display
     */
    public void displayListSearch(List<Doctor> doctors) {
        if (!doctors.isEmpty()) {
            doctors.forEach((Doctor doctor) -> {
                doctor.display();
            });
        } else {
            System.out.println("Can't not find the doctor.");
        }
    }

    /**
     * Display the information of doctor.
     */
    public void display() {
        if (!ld.isEmpty()) {
            ld.forEach((Doctor doctor) -> {
                doctor.display();
            });
        } else {
            System.out.println("");
        }
    }
}
