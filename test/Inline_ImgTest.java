import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

import Token.Inline_Img;

public class Inline_ImgTest {

	private static LinkedList<String> values;
	private static LinkedList<String> expected;

	@BeforeClass
	public static void setUpList() {
		values = new LinkedList<String>();
		values.add("![Alt text](/path/to/img.jpg)");
		values.add("![Alt text](/path/to/img.jpg \'Optional title\')");
		values.add("![kitty 1](http://instax.com/kitty/en/img/kittycheki.png)");
		values.add("![kitty](http://instax.com/kitty/en/img/kittycheki.png \"Hello Kitty\")");
		values.add("![kitty](C:\\kitty.png \"Hello Kitty\")");
		expected = new LinkedList<String>();
		expected.add("<img src=\"/path/to/img.jpg\" alt=\"Alt text\"/>");
		expected.add("<img src=\"/path/to/img.jpg\" alt=\"Alt text\" title=\"Optional title\"/>");
		expected.add("<img src=\"http://instax.com/kitty/en/img/kittycheki.png\" alt=\"kitty 1\"/>");
		expected.add("<img src=\"http://instax.com/kitty/en/img/kittycheki.png\" alt=\"kitty\" title=\"Hello Kitty\"/>");
		expected.add("<img src=\"C:/kitty.png\" alt=\"kitty\" title=\"Hello Kitty\"/>");
	}

	@Test
	public void testInline_Img() {
		for (int i = 0; i < values.size(); i++) {
			Inline_Img in = new Inline_Img(values.get(i));
			assertEquals(in.generate(), expected.get(i));
		}
		}
}
