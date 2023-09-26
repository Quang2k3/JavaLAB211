package Main;

import logic.LinearSearch;
import static validate.Validate.getInt;

/**
 *
 * @author Quang
 */
public class Main {
    public static void main(String[] args) {
        int numberOfArray = getInt(
                "Enter number of array: ", 
                "Number must be integer", 
                "Number of array", 0, Integer.MAX_VALUE
        );
        
        int searchValue = getInt(
                "Enter search value: ", 
                "Search value must be integer", 
                "Search value", 
                Integer.MIN_VALUE, 
                Integer.MAX_VALUE
        );
        LinearSearch search = new LinearSearch(numberOfArray);
        search.generateRandomIntegerOfArray();
        search.displayArray();
        search.linearSearch(searchValue);
        search.displayIndexArray(searchValue);
    }
}
