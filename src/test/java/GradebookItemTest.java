import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import gradebook.model.*;

public class GradebookItemTest {

	GradebookCategory tests = new GradebookCategory("Tests", 0.4);
	GradebookItem test1 = new GradebookItem("test1", 90, tests);
	
	@Test
	public void testGBIParams() {
		assertTrue(test1.getScore() == 90);
		assertTrue(test1.getGradebookCategory().getGradingWeight() == 0.4);
	}
}