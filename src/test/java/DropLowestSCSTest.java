import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class DropLowestSCSTest {

	GradebookCategory hw = new GradebookCategory("hw", 0.15);
	GradebookCategory finalExam = new GradebookCategory("final", 0.3);
	
	@Test
	public void testHWScore() {
		ArrayList<GradebookItem> homeworkItems = new ArrayList<>();
		homeworkItems.add(new GradebookItem("HW1", 100, hw));
		homeworkItems.add(new GradebookItem("HW2", 100, hw));
		homeworkItems.add(new GradebookItem("HW3", 0, hw));
		
		DropLowestStandardCutoffScheme homeworkScheme = 
		new DropLowestStandardCutoffScheme(homeworkItems);
		
		homeworkScheme.calculateCategoryScore(hw);
		assertTrue(homeworkScheme.getOverallScore() == 100);
	}
	
	@Test 
	public void testFinalExamScore() {
		ArrayList<GradebookItem> finalExamItem = new ArrayList<>();
		finalExamItem.add(new GradebookItem("Final", 95, finalExam));
		
		DropLowestStandardCutoffScheme finalScheme = 
		new DropLowestStandardCutoffScheme(finalExamItem);
		
		finalScheme.calculateCategoryScore(finalExam);
		assertTrue(finalScheme.getOverallScore() == 95);
	}
}