/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Validation;

/**
 *
 * @author admin
 */
public class Main {
    
    public static void main(String[] args) {
        ViewTask viewTask = new ViewTask();
        while (true) {
            menu();
            int choice = Validation.getInputInteger("Please enter the choice: ", "You must be enter the digits",
                    1, 4);
            switch (choice) {
                case 1: {
                    viewTask.addTask();
                    break;
                }
                case 2: {
                    viewTask.deleteTask();
                    break;
                }
                case 3: {
                    viewTask.displayTask();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
            }
        }
    }
    
    private static void menu() {
        System.out.println("========= Task program =========");
        System.out.println("   1. Add Task");
        System.out.println("   2. Delete Task");
        System.out.println("   3. Display Task");
        System.out.println("   4. exit");
        System.out.println("================================");
    }
}
