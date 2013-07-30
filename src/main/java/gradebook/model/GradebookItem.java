package gradebook.model;

/**
* An item in the gradebook- e.g. "homework1" or "test1", with a given grade
* and category
*/
public class GradebookItem {

    private String name;
    private float score;
    private GradebookCategory gbCategory;

    public GradebookItem(String aName, float aScore,
           GradebookCategory aGradebookCategory) {
        this.name = aName;
        this.score = aScore;
        this.gbCategory = aGradebookCategory;
    }

    public float getScore() {
        return score;
    }

    public GradebookCategory getGradebookCategory() {
        return gbCategory;
    }
}
