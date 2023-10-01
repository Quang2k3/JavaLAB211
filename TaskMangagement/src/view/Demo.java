/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Demo {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputString(String msg) {
        while (true) {
            System.out.print(msg);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("NOT EMPTY!!!!");
            } else {
                return string;
            }
        }
    }

    public static String getFormatDate(String msg, String regex) {
        while (true) {
            String date = getInputString(msg);
            if (!date.matches(regex)) {
                System.out.println("You must be enter correct form dd-MM-yyyy");
            } else {
                return date;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("----------------------------------------- Task -------------------------------------------------------");
//        System.out.printf("%-10s%-20s%-18s%-15s%-15s%-15s%-10s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
//        System.out.printf("%-10s%-20s%-18s%-15s%-15s%-15s%-10s\n", 1, "Dev Program", "Code", "28-08-2015", "8.0", "Dev", "Lead");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        Date date = null;
        while (true) {
            try {
                //check format date
                String checkDate = getFormatDate("Enter date: ", "\\d{1,2}-\\d{1,2}-\\d{4}");
                //check correct date in year
                date = simpleDateFormat.parse(checkDate);
                break;
            } catch (ParseException parseException) {
                System.out.println("You must be to enter correct date in year");
            }

        }
        System.out.println(simpleDateFormat.format(date));
    }
}
