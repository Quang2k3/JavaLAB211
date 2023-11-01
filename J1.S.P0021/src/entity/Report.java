package entity;

/**
 *
 * @author Quang
 */
public class Report {
    
    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    public void input(Student info){
        this.studentName = info.getStName();
        this.courseName = info.getCourseName();
        this.totalCourse = 1;
    }
    
    public void display(){
        System.out.printf("|%10s |%10s |%10s ", studentName, courseName, totalCourse);
    }
}
