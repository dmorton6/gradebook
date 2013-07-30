import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class ClassTest {

    GradebookCategory hw = new GradebookCategory("hw", 0.5);
    GradebookCategory tests = new GradebookCategory("tests", 0.5);

    @Test
    public void testClassScore() {
        ArrayList<GradebookItem> studentItems = new ArrayList<>();
        studentItems.add(new GradebookItem("HW1", 80, hw));
        studentItems.add(new GradebookItem("HW2", 30, hw));
        studentItems.add(new GradebookItem("midterm", 90, tests));

        DropLowestStandardCutoffScheme studentScheme =
        new DropLowestStandardCutoffScheme(studentItems);

        Student johnSmith = new Student("John Smith", studentScheme);
        Student janeSmith = new Student("Jane Smith", studentScheme);

        ArrayList<Student> cs2340Astudents = new ArrayList<>();
        cs2340Astudents.add(johnSmith);
        cs2340Astudents.add(janeSmith);

        Section cs2340A = new Section(cs2340Astudents);
        Section cs2340B = new Section(cs2340Astudents);
        // Note: the section scores are 85 across the board

        ArrayList<Section> cs2340_sections = new ArrayList<>();
        cs2340_sections.add(cs2340A);
        cs2340_sections.add(cs2340B);

        gradebook.model.Class cs2340_fall2013 =
        new gradebook.model.Class(cs2340_sections);

        assertTrue(cs2340_fall2013.getScore() == 85);
    }

    @Test
    public void testClassLetterGrade() {
        ArrayList<GradebookItem> studentItems = new ArrayList<>();
        studentItems.add(new GradebookItem("HW1", 80, hw));
        studentItems.add(new GradebookItem("HW2", 30, hw));
        studentItems.add(new GradebookItem("midterm", 90, tests));

        DropLowestStandardCutoffScheme studentScheme =
        new DropLowestStandardCutoffScheme(studentItems);

        Student johnSmith = new Student("John Smith", studentScheme);
        Student janeSmith = new Student("Jane Smith", studentScheme);

        ArrayList<Student> cs2340Astudents = new ArrayList<>();
        cs2340Astudents.add(johnSmith);
        cs2340Astudents.add(janeSmith);

        Section cs2340A = new Section(cs2340Astudents);
        Section cs2340B = new Section(cs2340Astudents);
        // Note: the section scores are 85 across the board

        ArrayList<Section> cs2340_sections = new ArrayList<>();
        cs2340_sections.add(cs2340A);
        cs2340_sections.add(cs2340B);

        gradebook.model.Class cs2340_fall2013 =
        new gradebook.model.Class(cs2340_sections);

        assertTrue(cs2340_fall2013.getLetterGrade() == 'B');
    }


}