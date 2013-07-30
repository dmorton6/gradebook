import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class SectionTest {

	GradebookCategory hw = new GradebookCategory("hw", 0.5);
	GradebookCategory tests = new GradebookCategory("tests", 0.5);
	
	@Test
	public void testSectionScore() {
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
		
		//Note: the student scores for both students should be 85
		assertTrue(cs2340A.getScore() == 85);
	}
	
	@Test
	public void testSectionLetterGrade() {
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
		
		//Note: the student scores for both students should be 85
		assertTrue(cs2340A.getLetterGrade() == 'B');
	}
	

}