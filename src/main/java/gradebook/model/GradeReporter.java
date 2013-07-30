package gradebook.model;

/**
* The framework of this class allows for uniform reporting of grades.
* By including a GradingScheme object in this class, all extending classes
* have the ability to implement new types of schemes to calculate class
* average scores and letter grades.
*/
public abstract class GradeReporter implements ReportsGrades, Gradeable {

    protected double averageScore;
    protected char averageLetterGrade;
    protected GradingScheme gradingScheme;

    public String reportAverageScore(String objType) {
        return ("The average score for this " + objType + " was "
                + averageScore + ".");
    }

    public String reportAverageLetterGrade(String objType) {
        return ("The average score for this " + objType + " was a(n) "
                + averageLetterGrade + ".");
    }

    public void convertScoreToLetterGrade(double score) {
        gradingScheme.convertScoreToLetterGrade(score);
        averageLetterGrade = gradingScheme.getLetterGrade();
    }

    protected double convertLetterGradeToGPA(char letterGrade) {
        switch (letterGrade) {
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            case 'D': return 1;
            default: return 0;
        }
    }

    protected char convertGPAToLetterGrade(double gpa) {
        if (gpa > 3.0) { return 'A';
        } else if (gpa > 2.0) { return 'B';
        } else if (gpa > 1.0) { return 'C';
        } else if (gpa > 0) { return 'D';
        } else { return 'F';
        }
    }

    public double getScore() {
        return averageScore;
    }

    public char getLetterGrade() {
        return averageLetterGrade;
    }
}
