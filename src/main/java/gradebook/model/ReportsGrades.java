package gradebook.model;

/**
* Interface for anything that needs to reports grades, such as a course
*/
public interface ReportsGrades {

    String reportAverageScore(String objType);
    String reportAverageLetterGrade(String objType);

}
