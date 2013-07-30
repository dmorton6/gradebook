package gradebook.model;
import java.util.ArrayList;

/**
* Extends Course functionality to a specific semester offering of the course
*/
public class Class extends GradeReporter {

    private ArrayList<Section> sections;

    public Class(ArrayList<Section> someSections) {
        this.sections = someSections;
        calculateClassScore();
        calculateClassLetterGrade();
    }

    private void calculateClassScore() {
        double totalScore = 0;
        for (int i = 0; i < sections.size(); i++) {
            totalScore += sections.get(i).getScore();
        }
        averageScore = totalScore / (double) sections.size();
    }

    private void calculateClassLetterGrade() {
        double totalGPA = 0, avgGPA = 0;
        for (int i = 0; i < sections.size(); i++) {
            char tempLetter = sections.get(i).getLetterGrade();
            totalGPA += super.convertLetterGradeToGPA(tempLetter);
        }
        avgGPA = totalGPA / (double) sections.size();
        averageLetterGrade = convertGPAToLetterGrade(avgGPA);
    }

    public String reportAverageScore() {
        return super.reportAverageScore("class");
    }

    public String reportAverageLetterGrade() {
        return super.reportAverageScore("class");
    }

}
