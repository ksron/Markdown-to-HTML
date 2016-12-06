import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;
import Token.Escape;

public class EscapeTest {

	private static LinkedList<String> values;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("\\`");
		values.add("\\*");
		values.add("\\_");
		values.add("\\{");
		values.add("\\}");
		values.add("\\[");
		values.add("\\]");
		values.add("\\(");
		values.add("\\)");
		values.add("\\#");
		values.add("\\.");
		values.add("\\!");
		values.add("\\\\");
	}

	@Test
	public void testEscape() {
		for (int i = 0; i < values.size(); i++) {
			Escape escape = new Escape(values.get(i));
			if (values.get(i).equals("\\\\"))
				assertEquals(escape.generate(), "\\");
			else
				assertEquals(escape.generate(), values.get(i).replace("\\", ""));
		}
	}

}