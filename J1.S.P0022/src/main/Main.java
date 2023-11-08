package main;

import bo.CandidateBO;
import entity.Candidate;
import java.util.ArrayList;
import validate.Validate;
import constant.Constant;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        
        CandidateBO candidateBO = new CandidateBO(new ArrayList<>());
        
        while (true) {
            System.out.println("1. Experiences.");
            System.out.println("2. Fresher.");
            System.out.println("3. Internship.");
            System.out.println("4. Searching.");
            System.out.println("5. Exit.");
            int choice = Validate.getInt(
                    "Enter your choice.",
                    "Number value out of range.",
                    "Invalid integer number.",
                    1, 5
            );

            switch (choice) {
                case 1:
                    if (candidateBO.add(Constant.EXPERIENCE_TYPE)) {
                        System.out.println("Experiences added successfully.");
                    } else {
                        System.out.println("Failed to add experiences.");
                    }
                    break;
                case 2:
                    if (candidateBO.add(Constant.FRESHER_TYPE)) {
                        System.out.println("Fresher added successfully.");
                    } else {
                        System.out.println("Failed to add fresher.");
                    }
                    break;
                case 3:
                    if (candidateBO.add(Constant.INTERN_TYPE)) {
                        System.out.println("Intern added successfully.");
                    } else {
                        System.out.println("Failed to add intern.");
                    }
                    break;
                case 4:
                    candidateBO.displayListSearch();
                    String textSearch = Validate.getString(
                            "Input candidate name search: ",
                            "Invalid name", Constant.REGEX_NAME
                    );

                    int type = Validate.getInt(
                            "Input type of candidate: ",
                            "number value out of range.",
                            "Invalid integer number.", 0, 2
                    );
                    candidateBO.display(candidateBO.search(textSearch, type));
                    break;
                case 5:
                    break;
            }
        }
    }
}