package gradebook.model;
import java.util.ArrayList;

/**
* The framework of this class allows for the extension of many different types
* of grading schemes
*/
public abstract class GradingScheme implements Gradeable {

    protected char letterGrade;
    protected double overallScore;
    protected double cutoffA, cutoffB, cutoffC, cutoffD;
    protected int numCategories;
    protected ArrayList<GradebookItem> gbItems, gbCategoryItems;
    // gbItems is for a listing of GradebookItems of any category
    // All items in gbCategoryItems will all belong to the same category,
    // as set by the setCategoryItems() method

    public abstract void setCutoffs();
    public abstract void calculateCategoryScore(GradebookCategory gbCategory);

    protected void setCategoryItems(GradebookCategory gbCategory) {
        int maxSize = gbItems.size();
        gbCategoryItems = new ArrayList<>(maxSize);

        for (int i = 0; i < gbItems.size(); i++) {
            if (gbItems.get(i).getGradebookCategory().equals(gbCategory)) {
                gbCategoryItems.add(gbItems.get(i));
            }
        }
    }

    public ArrayList<GradebookCategory> getCategories() {
        GradebookCategory tempCat;

        ArrayList<GradebookCategory> gbCategories = new ArrayList<>();
        gbCategories.add(gbItems.get(0).getGradebookCategory());

        for (int i = 1; i < gbItems.size(); i++) {
            tempCat = gbItems.get(i).getGradebookCategory();
            if (!(gbCategories.contains(tempCat))) {
                gbCategories.add(tempCat);
            }
        }
        return gbCategories;
    }

    protected void setCutoffsAsStandard() {
        cutoffA = STANDARD_CUTOFF_A;
        cutoffB = STANDARD_CUTOFF_B;
        cutoffC = STANDARD_CUTOFF_C;
        cutoffD = STANDARD_CUTOFF_D;
    }

    public void convertScoreToLetterGrade(double score) {
        if (score >= cutoffA) { letterGrade = 'A';
        } else if (score >= cutoffB) { letterGrade = 'B';
        } else if (score >= cutoffC) { letterGrade = 'C';
        } else if (score >= cutoffD) { letterGrade = 'D';
        } else { letterGrade = 'F';
        }
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public int getNumCategories() {
        return numCategories;
    }
}
