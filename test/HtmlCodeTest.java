import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;
import Token.HtmlCode;


public class HtmlCodeTest {

	private static LinkedList<String> values;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("<html>"
				+ "<head>"
				+ "<title>Page Title</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>This is a Heading</h1>"
				+ "<p>This is a paragraph.</p>"
				+ "</body>"
				+ "</html>");
	}

	@Test
	public void testHtmlCode() {
		for (int i = 0; i < values.size(); i++) {
			HtmlCode h = new HtmlCode(values.get(i));
			assertEquals(h.generate(),values.get(i));
		}
	}

}