
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Main {

    private static final Scanner Input = new Scanner(System.in);

    /**
     *
     * @param messege : notification enter value
     * @param error : notification catch exception
     * @param variabe : name variable
     * @param min : value min user enter
     * @param max : value max user enter
     * @return value input
     */
    public static int getInput(String messege, String error, String variabe,
            int min, int max) {

        //loop check correct format input value
        while (true) {
            //check expection formart is not digit
            try {
                System.out.println(messege);
                int valueInput = Integer.parseInt(Input.nextLine());
                
                //value range min to max
                if (valueInput >= min && valueInput <= max) {
                    return valueInput;
                }else{
                    System.out.println(variabe + " must be range " + min 
                            +" - " + max);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(error);
            }
        }
    }

    public static void main(String[] args) {
        //get value number of array
        int numberOfArray = getInput("Enter number of array:",
                "Number must be integer", "Number of array", 0, Integer.MAX_VALUE);

        //get value search
        int searchValues = getInput("Enter search value:",
                "Search value must be integer", "search value",
                Integer.MIN_VALUE, Integer.MAX_VALUE);

        //declare array integer
        LinearSearch linearSearch = new LinearSearch(numberOfArray);

        //generate random interger
        linearSearch.generateRandomIntegerInArray();

        //display array integer
        linearSearch.displayTheArray();

        //use algorithm linear search
        linearSearch.algorithmLinearSearch(searchValues);

        //display index of search value
        linearSearch.displayIndexOfSeachNumberInArray(searchValues);
    }
}
