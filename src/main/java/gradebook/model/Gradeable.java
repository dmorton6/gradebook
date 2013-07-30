package gradebook.model;

/**
* Interface for GradingSchemes
*/
public interface Gradeable {

    float STANDARD_CUTOFF_A = 90;
    float STANDARD_CUTOFF_B = 80;
    float STANDARD_CUTOFF_C = 70;
    float STANDARD_CUTOFF_D = 60;

    void convertScoreToLetterGrade(double score);

}
