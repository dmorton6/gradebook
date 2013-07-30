package gradebook.model;
import java.util.ArrayList;

/**
* Represents an individual course, independent of semester
*/
public class Course extends GradeReporter {

    private String subject, courseName;
    private int courseNumber;
    private ArrayList<Course> prereqs;
    private ArrayList<Class> classes; // all classes for that course

    public Course(String aSubject, int aCourseNumber, String aCourseName,
                  ArrayList<Course> somePrereqs,
                  ArrayList<Class> someClasses) {
        this.subject = aSubject;
        this.courseNumber = aCourseNumber;
        this.courseName = aCourseName;
        this.prereqs = somePrereqs;
        this.classes = someClasses;
        calculateCourseScore();
        calculateCourseLetterGrade();
    }

    private void calculateCourseScore() {
        double totalScore = 0;
        for (int i = 0; i < classes.size(); i++) {
            totalScore += classes.get(i).getScore();
        }
        averageScore = totalScore / (double) classes.size();
    }

    private void calculateCourseLetterGrade() {
        double totalGPA = 0, avgGPA = 0;
        for (int i = 0; i < classes.size(); i++) {
            char tempLetter = classes.get(i).getLetterGrade();
            totalGPA += super.convertLetterGradeToGPA(tempLetter);
        }
        avgGPA = totalGPA / (double) classes.size();
        averageLetterGrade = convertGPAToLetterGrade(avgGPA);
    }


    public String reportAverageScore() {
        return super.reportAverageScore("course");
    }

    public String reportAverageLetterGrade() {
        return super.reportAverageLetterGrade("course");
    }

    public String getSubject() {
        return this.subject;
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setPrereqs(ArrayList<Course> somePrereqs) {
        this.prereqs = somePrereqs;
    }

    public ArrayList<Course> getPrereqs() {
        return this.prereqs;
    }

}
