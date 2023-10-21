package entity;

/**
 *
 * @author Quang
 */
public class Report {
    
    private String name;
    
    private String courseName;
    
    private int totalOfCourse;

    public Report() {
    }

    public Report(String name, String courseName, int totalOfCourse) {
        this.name = name;
        this.courseName = courseName;
        this.totalOfCourse = totalOfCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }
    
    public void input(Student info) {
        this.name = info.getCourseName();
        this.courseName = info.getStName();
        this.totalOfCourse = 1;
    }
    
    public void display() {
        System.out.printf("|%10s |%10s |%10s \n", name, courseName, totalOfCourse);
    }
}
