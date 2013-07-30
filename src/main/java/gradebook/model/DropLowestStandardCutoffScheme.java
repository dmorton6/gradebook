package gradebook.model;
import java.util.ArrayList;

/**
* An example implementation of GradingScheme, created for testing purposes
* In this implementation, the lowest grade in a certain category is dropped
*/
public class DropLowestStandardCutoffScheme extends GradingScheme {

    public DropLowestStandardCutoffScheme(ArrayList<GradebookItem> someGBIs) {
        this.gbItems = someGBIs;
        setCutoffs();
    }

    public void setCutoffs() {
        super.setCutoffsAsStandard();
    }

    public void calculateCategoryScore(GradebookCategory gbCategory) {
        super.setCategoryItems(gbCategory);

        // first, take care of cases where there is only one item
        // we do not want to drop the only final exam grade, for example
        if (gbCategoryItems.size() == 1) {
            overallScore = gbCategoryItems.get(0).getScore();
            return;
        }

        // for multiple items in the category: first, find the minimum score
        double tempScore, totalScore = 0;
        double minScore = gbCategoryItems.get(0).getScore();

        for (int i = 0; i < gbCategoryItems.size(); i++) {
            tempScore = gbCategoryItems.get(i).getScore();
            if (minScore > tempScore) {
                minScore = tempScore;
            }
            totalScore += tempScore;
        }

        // that score is then removed for calculating the overall score
        overallScore = (totalScore - minScore)
                       / (gbCategoryItems.size() - 1);
    }

}
