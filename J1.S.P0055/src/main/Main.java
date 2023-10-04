package main;

import entity.Doctor;
import java.util.ArrayList;
import logic.Manager;

/**
 *
 * @author Quang
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        while (true) {            
            int choice = Manager.menu();
            switch (choice) {
                case 1: 
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    Manager.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }
        }
    }
}
