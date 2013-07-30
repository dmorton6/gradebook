package gradebook.model;
import java.util.ArrayList;

/**
* A Class with a particular group of students
*/
public class Section extends GradeReporter {

    private ArrayList<Student> sectionStudents;

    public Section(ArrayList<Student> someStudents) {
        this.sectionStudents = someStudents;
        calculateSectionScore();
        calculateSectionLetterGrade();
    }

    private void calculateSectionScore() {
        double totalScore = 0;
        for (int i = 0; i < sectionStudents.size(); i++) {
            totalScore += sectionStudents.get(i).getStudentSectionScore();
        }
        averageScore = totalScore / (double) sectionStudents.size();
    }

    private void calculateSectionLetterGrade() {
        double totalGPA = 0, avgGPA = 0;
        for (int i = 0; i < sectionStudents.size(); i++) {
            char tempLetter = sectionStudents.get(i)
                                             .getStudentSectionLetterGrade();
            totalGPA += super.convertLetterGradeToGPA(tempLetter);
        }
        avgGPA = totalGPA / (double) sectionStudents.size();
        averageLetterGrade = convertGPAToLetterGrade(avgGPA);
    }


    public String reportAverageScore() {
        return super.reportAverageScore("section");
    }

    public String reportAverageLetterGrade() {
        return super.reportAverageScore("section");
    }

}
