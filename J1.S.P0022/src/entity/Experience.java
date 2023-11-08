package entity;

import java.util.List;
import validate.Validate;
import constant.Constant;

/**
 *
 * @author Quang
 */
public class Experience extends Candidate{
    
    private int exInYear;
    private String skill;

    public Experience() {
    }

    public Experience(
            int exInYear, String skill, 
            int id, String firstName, 
            String lastName, int birthDAte, 
            String address, String phone, 
            String email, int type
    ) {
        super(id, firstName, lastName, birthDAte, address, phone, email, type);
        this.exInYear = exInYear;
        this.skill = skill;
    }
    
    public void input(List<Candidate> list) {
        super.input(list);
        
        this.exInYear = Validate.getInt(
                "Enter year of experience: ", 
                "Number value out of range.", 
                "Invalid integer number.", 1, 100
        );
        
        this.skill = Validate.getString(
                "Enter your skill: ", 
                "Invalid skill.", 
                Constant.REGEX_TEXT
        );
        
        this.setType(Constant.EXPERIENCE_TYPE);
    }
}
