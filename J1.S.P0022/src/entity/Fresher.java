package entity;

import java.util.List;
import validate.Validate;
import constant.Constant;
import java.util.Calendar;

/**
 *
 * @author Quang
 */
public class Fresher extends Candidate{
    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(
            int graduationDate, String graduationRank, 
            String education, int id, String firstName, 
            String lastName, int birthDAte, 
            String address, String phone, 
            String email, int type
    ) {
        super(id, firstName, lastName, birthDAte, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    
    private String getInputGraduationRank() {
        System.out.println(" 1. Excellence");
        System.out.println(" 2. Good");
        System.out.println(" 3. Fair");
        System.out.println(" 4. Poor");

        int choice = Validate.getInt(
                "Select graduation rank ",
                "Number value out of range",
                "Invalid integer number",
                1, 4
        );
        switch (choice) {
            case 1:
                return "Excellence";
            case 2:
                return "Good";
            case 3:
                return "Fair";
            case 4:
                return "Poor";
        }
        return "none";
    }
    
    /**
     * Create a new fresher.
     *
     * @param list to store candidate.
     */
    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        this.graduationDate = Validate.getInt(
                "Enter graduation time: ", 
                "Number value out of range.", 
                "Invalid integer number.", 
                Constant.MIN_YEAR, 
                Calendar.getInstance().get(Calendar.YEAR)
        );
        
        this.graduationRank = getInputGraduationRank();
        
        this.education = Validate.getString("Enter education: ",
                "Invalid education.",
                Constant.REGEX_TEXT);
        this.setType(Constant.FRESHER_TYPE);
    }
}
