package entity;

import java.util.List;
import validate.Validate;
import constant.Constant;

/**
 *
 * @author Quang
 */
public class Intern extends Candidate{
    private String major;
    private int semester;
    private String university;

    public Intern() {
    }

    public Intern(
            String major, int semester, 
            String university, int id, 
            String firstName, String lastName, 
            int birthDAte, String address, 
            String phone, String email, int type
    ) {
        super(id, firstName, lastName, birthDAte, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }
    
    @Override
    public void input(List<Candidate> list) {
        super.input(list);
        
        this.major = Validate.getString(
                "Enter major: ", 
                "Invalid major.", 
                Constant.REGEX_TEXT
        );
        
        this.semester = Validate.getInt(
                "Enter semesster: ", 
                "Number value out of range.", 
                "Invalid intefer number.", 
                1, 100
        );
        
        this.university = Validate.getString(
                "Enter university: ", 
                "Invalid universisty.", 
                Constant.REGEX_TEXT
        );
        this.setType(Constant.INTERN_TYPE);
    }
}
