import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;
import Token.Escape;
import Token.SpecialChar;

public class SpecialCharTest {
	private static LinkedList<String> values;
	private static LinkedList<String> expected;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("&");
		values.add("&amp;");
		values.add("<");
		values.add(">");
		expected = new LinkedList<String>();
		expected.add("&amp;");
		expected.add("&amp;");
		expected.add("&lt;");
		expected.add("&gt;");
	}

	@Test
	public void testSpecialChar() {
		for (int i = 0; i < values.size(); i++) {
			SpecialChar s = new SpecialChar(values.get(i));
			assertEquals(s.generate(), expected.get(i));
		}
	}

}
