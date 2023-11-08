package bo;

import entity.Candidate;
import java.util.List;
import validate.Validate;
import constant.Constant;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Quang
 */
public class CandidateBO {

    private List<Candidate> list;

    public CandidateBO() {
    }

    public CandidateBO(List<Candidate> list) {
        this.list = list;
    }

    public boolean add(int type) {
        Candidate newCandidate = null;
        do {
            switch (type) {
                case Constant.EXPERIENCE_TYPE:
                    newCandidate = new Experience();
                    break;
                case Constant.FRESHER_TYPE:
                    newCandidate = new Fresher();
                    break;
                case Constant.INTERN_TYPE:
                    newCandidate = new Intern();
                    break;
            }
            newCandidate.input(list);
            return list.add(newCandidate);
        } while (Validate.isContinue());
    }

    public List<Candidate> search(String searchName, int type) {
        List<Candidate> foundCandidates = new ArrayList<>();

        for (Candidate candidate : this.list) {
            if (candidate.getFullName().toLowerCase().contains(searchName.toLowerCase())
                    && candidate.getType() == type) {
                foundCandidates.add(candidate);
            }
        }
        return foundCandidates;
    }

    public void displayListSearch() {
        list.sort(Comparator.comparingInt(Candidate::getType));
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        int i = 0;
        for (Candidate candidate : this.list) {
            if (candidate.getType() == 1 && i == 0) {
                System.out.println("=============FRESHER CANDIDATE=============");
                i++;
            }

            if (candidate.getType() == 2 && i == 1) {
                System.out.println("=============INTERN CANDIDATE==============");
                i++;
            }
            candidate.displayFullName();
        }
    }

    public void display(List<Candidate> listResult) {
        if (listResult.isEmpty()) {
            System.out.println("\nNot found,");
        } else {
            System.out.println("\nThe candidate found: ");
            listResult.forEach(System.out::println);
        }
    }
}
