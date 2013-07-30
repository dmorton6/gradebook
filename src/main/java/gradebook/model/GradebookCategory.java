package gradebook.model;

/**
* A category for GradebookItems- e.g. "tests" or "homework"
*/
public class GradebookCategory {

    private String name;
    private double gradingWeight; //between 0 and 1

    public GradebookCategory(String aName, double aWeight) {
        this.name = aName;
        this.gradingWeight = aWeight;
    }

    public boolean equals(GradebookCategory gbCategory) {
        return (gradingWeight == gbCategory.getGradingWeight()
                && name.equals(gbCategory.getName()));
    }

    public String getName() {
        return name;
    }

    public double getGradingWeight() {
        return gradingWeight;
    }
}
