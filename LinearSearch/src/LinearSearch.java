
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class LinearSearch {

    int array[];
    
    /**
     * @param numberOfArray
     * help array have numberOfArray
     */
    public LinearSearch(int numberOfArray) {
        array = new int[numberOfArray];
    }
    
    /**
     * generate random Integer range for each array element
     */
    public void generateRandomIntegerInArray(){
        Random random = new Random();
        //loop use to generate random integer
        for (int i = 0; i < array.length; i++) {
            //random integer
            array[i] = random.nextInt(array.length + 1);
        }
    }
    /**
     * display the array
     */
    public void displayTheArray(){
        //dislay array
        System.out.println("The array: " + Arrays.toString(array));
    }
    
    /**
     * algorithm linear search
     * @param searchValue
     * @return index of value user find
     */
    public int algorithmLinearSearch(int searchValue){
        //loop use to find the index of search value
        for (int i = 0; i < array.length; i++) {
            //if found return index
            if(array[i] == searchValue) return i;
        }
        //not found return -1
        return -1;
    }
    
    /**
     * display index of search number in array
     * @param searchValue 
     */
    public void displayIndexOfSeachNumberInArray(int searchValue){
        //find the index of search value
        int indexOfSearch = algorithmLinearSearch(searchValue);
        
        if(indexOfSearch != - 1)
            System.out.println("Found " + searchValue + " at index: " + indexOfSearch);
        else
            System.out.println("NOT FOUND");
        
    }
    
}
