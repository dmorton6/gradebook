import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class StudentTest {

	GradebookCategory hw = new GradebookCategory("hw", 0.5);
	GradebookCategory tests = new GradebookCategory("tests", 0.5);
	
	@Test
	public void testStudentScore() {
		ArrayList<GradebookItem> studentItems = new ArrayList<>();
		studentItems.add(new GradebookItem("HW1", 100, hw));
		studentItems.add(new GradebookItem("HW2", 30, hw));
		studentItems.add(new GradebookItem("midterm", 90, tests));
	
		DropLowestStandardCutoffScheme studentScheme = 
		new DropLowestStandardCutoffScheme(studentItems);
	
		Student johnSmith = new Student("John Smith", studentScheme);
		
		// average of equally-weighted 100 and 90 should be 95
		double studentScore = johnSmith.getStudentSectionScore();
		assertTrue(studentScore == 95);
	}
	
	@Test
	public void testStudentLetterGrade() {
		ArrayList<GradebookItem> studentItems = new ArrayList<>();
		studentItems.add(new GradebookItem("HW1", 80, hw));
		studentItems.add(new GradebookItem("tests", 80, tests));
		
		DropLowestStandardCutoffScheme studentScheme = 
		new DropLowestStandardCutoffScheme(studentItems);
	
		Student janeSmith = new Student("Jane Smith", studentScheme);
		
		double studentScore = janeSmith.getStudentSectionScore();
		
		// average of equally-weighted 80 and 80 should result in a B
		janeSmith.convertScoreToLetterGrade(studentScore);
		assertTrue(janeSmith.getStudentSectionLetterGrade() == 'B');
	}

}
