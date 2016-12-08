import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Token.Inline;

public class InlineTest {

	private static LinkedList<String> values;
	private static LinkedList<String> expected;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("[an example](http://example.com/ \"Title\")");
		values.add("[text](\\path\\to\\source.html)");
		expected = new LinkedList<String>();
		expected.add("<a href= \"http://example.com/\" title = \"Title\">an example</a>");
		expected.add("<a href = \"/path/to/source.html\">text</a>");
	}

	@Test
	public void testInline() {
		for (int i = 0; i < values.size(); i++) {
			Inline in = new Inline(values.get(i));
			assertEquals(expected.get(i),in.generate());
		}
	}

}
