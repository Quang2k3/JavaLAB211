/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    private static final Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @param msg : messenger
     * @return string
     */
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

    public static int getInputInteger(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("You must be enter to range " + min + " - " + max);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(err);
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

    public static Date getDate(String msg) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        Date date = null;
        while (true) {
            try {
                //check format date
                String checkDate = getFormatDate(msg, "\\d{1,2}-\\d{1,2}-\\d{4}");
                //check correct date in year
                date = simpleDateFormat.parse(checkDate);
                return date;
            } catch (ParseException parseException) {
                System.out.println("You must be to enter correct date in year");
            }

        }

    }

    public static String getStringPlan(String msg, String regex, double min, double max) {
        while (true) {
            String plan = getInputString(msg);
            if (!plan.matches(regex)) {
                System.out.println("You must be to correct format plane");
            } else {
                //compare
                if (converPlane(plan) >= min && converPlane(plan) <= max) {
                    return plan;
                } else {
                    System.out.println("You must be enter to " + min + " - " + max);
                }
            }
        }
    }

    private static double converPlane(String plan) {
        return Double.parseDouble(plan);
    }
}