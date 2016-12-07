import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Link_Addr;
import Token.Inline_Img;
import Token.Ref_Img;
import util.Lines;

public class Ref_ImgTest {

	private static LinkedList<String> id;
	private static LinkedList<String> reference;
	private static LinkedList<String> expected;

	@BeforeClass
	public static void setUpList() {
		id = new LinkedList<String>();
		id.add("![Alt text][id]");
		id.add("![Alt text][1]");
		id.add("![kitty 1][2]");
		id.add("![kitty][kitty_1]");
		id.add("![kitty][kitty_2]");
		id.add("![null Test][a]");
		
		reference = new LinkedList<String>();
		reference.add("[id]: /path/to/img.jpg");
		reference.add("[1]:  /path/to/img.jpg \'Optional title\'");
		reference.add("[2]:	http://instax.com/kitty/en/img/kittycheki.png");
		reference.add("[kitty_1]:	http://instax.com/kitty/en/img/kittycheki.png \"Hello Kitty\"");
		reference.add("[kitty_2]:		C:\\kitty.png \"Hello Kitty\")");
		
		expected = new LinkedList<String>();
		expected.add("<img src=\"/path/to/img.jpg\" alt=\"Alt text\"/>");
		expected.add("<img src=\"/path/to/img.jpg\" alt=\"Alt text\" title=\"Optional title\"/>");
		expected.add("<img src=\"http://instax.com/kitty/en/img/kittycheki.png\" alt=\"kitty 1\"/>");
		expected.add("<img src=\"http://instax.com/kitty/en/img/kittycheki.png\" alt=\"kitty\" title=\"Hello Kitty\"/>");
		expected.add("<img src=\"C:/kitty.png\" alt=\"kitty\" title=\"Hello Kitty\"/>");
		expected.add("![null Test][a]");
	}
	
	@Test
	public void testGenerate() {
		for (int i = 0; i < reference.size(); i++) {
			Link_Addr lin = new Link_Addr((Lines)(reference.get(i)));
			assertEquals(lin.generate(), expected.get(i));
		}
		for (int i = 0; i < id.size(); i++) {
			Ref_Img reImg = new Link_Addr((Lines)(reference.get(i)));
			assertEquals(reImg.generate(), expected.get(i));
		}
	}

}
