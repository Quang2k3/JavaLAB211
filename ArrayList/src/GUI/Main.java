package GUI;

import DTO.Person;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Quang", 20));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        for (Person person : list) {
            System.out.println(person);
        }
        
    }
}
