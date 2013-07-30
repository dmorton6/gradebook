import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class CourseTest {

    GradebookCategory hw = new GradebookCategory("hw", 0.5);
    GradebookCategory tests = new GradebookCategory("tests", 0.5);
	
	/* Note: the following two tests are very similar. The only current 
	 * difference between them is in the last line of code. However, they are
	 * kept as separate tests because (1) they are testing separate ideas (one 
	 * test per concept) and (2) they can be modified to test for different 
	 * student scores, GradingSchemes, etc.
	 * This is true for the tests in ClassTest and SectionTest as well.
	 */

    @Test
    public void testCourseScore() {
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

        gradebook.model.Class cs2340_spring2014 =
        new gradebook.model.Class(cs2340_sections);
		
		ArrayList<gradebook.model.Class> cs2340_classes = new ArrayList<>();
		cs2340_classes.add(cs2340_fall2013);
		cs2340_classes.add(cs2340_spring2014);
		
		Course cs2340 = new Course("CS", 2340, "Objects and Design", null, 
		                            cs2340_classes);
		
		assertTrue(cs2340.getScore() == 85);	
    }

	@Test
    public void testCourseLetterGrade() {
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

        gradebook.model.Class cs2340_spring2014 =
        new gradebook.model.Class(cs2340_sections);
		
		ArrayList<gradebook.model.Class> cs2340_classes = new ArrayList<>();
		cs2340_classes.add(cs2340_fall2013);
		cs2340_classes.add(cs2340_spring2014);
		
		Course cs2340 = new Course("CS", 2340, "Objects and Design", null, 
		                            cs2340_classes);
		
		assertTrue(cs2340.getLetterGrade() == 'B');	
    }

}
