import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class GradebookCategoryTest {

	GradebookCategory tests = new GradebookCategory("Tests", 0.4);
	GradebookCategory testsEquivalent = new GradebookCategory("Tests", 0.4);
	GradebookCategory hw = new GradebookCategory("Homework", 0.15);
	
	@Test
	public void testGBCParams() {
		assertTrue(tests.getName().equals("Tests"));
		assertTrue(tests.getGradingWeight() == 0.4);
	}
	
	@Test
	public void testEquivalence() {
		assertTrue(tests.equals(testsEquivalent));
		assertFalse(tests.equals(hw));
	}
}