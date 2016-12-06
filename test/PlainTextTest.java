import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;
import Token.PlainText;

public class PlainTextTest {
	private static LinkedList<String> values;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("This is plain Text");
	}

	@Test
	public void testPlainText() {
		for (int i = 0; i < values.size(); i++) {
			PlainText p = new PlainText(values.get(i));
			assertEquals(p.generate(),values.get(i));
		}
	}
}
