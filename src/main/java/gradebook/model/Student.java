package gradebook.model;
import java.util.ArrayList;

/**
* An individual student, capable of calculating grades
* Current functionality does not calculate the student's score over multiple
* sections, but such functionality could be added easily if necessary. This is
* why the student's getter methods denote "SectionScore", so that such
* methods could be added more easily. Therefore, the "getScore()" method is
* considered ambiguous for Students and not used.
*/
public class Student extends GradeReporter {

    private String name;
    private ArrayList<GradebookItem> studentItems;

    public Student(String aName, GradingScheme aGradingScheme) {
        this.name = aName;
        this.gradingScheme = aGradingScheme;
        calculateAverageScore();
        calculateAverageLetterGrade();
    }

    public void calculateAverageScore() {
        GradebookCategory tempCat;
        averageScore = 0;

        ArrayList<GradebookCategory> gbCategories =
        gradingScheme.getCategories();

        for (int i = 0; i < gbCategories.size(); i++) {
            tempCat = gbCategories.get(i);
            gradingScheme.calculateCategoryScore(tempCat);
            averageScore += (gradingScheme.getOverallScore()
                            * tempCat.getGradingWeight());
        }
    }

    public void calculateAverageLetterGrade() {
        super.convertScoreToLetterGrade(averageScore);
    }


    public double getStudentSectionScore() {
        return averageScore;
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public char getStudentSectionLetterGrade() {
        return averageLetterGrade;
    }

    public String getName() {
        return name;
    }
}
