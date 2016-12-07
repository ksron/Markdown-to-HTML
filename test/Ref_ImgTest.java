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
		reference.add("[kitty_2]:		C:\\kitty.png \"Hello Kitty\"");
		
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
		Lines lines1 = new Lines();
		lines1.append("[id]: /path/to/img.jpg");
		Link_Addr lin1 = new Link_Addr(lines1);
		
		Lines lines2 = new Lines();
		lines2.append("[1]:  /path/to/img.jpg \'Optional title\'");
		Link_Addr lin2 = new Link_Addr(lines2);
		
		Lines lines3 = new Lines();
		lines3.append("[2]:	http://instax.com/kitty/en/img/kittycheki.png");
		Link_Addr lin3 = new Link_Addr(lines3);
		
		Lines lines4 = new Lines();
		lines4.append("[kitty_1]:	http://instax.com/kitty/en/img/kittycheki.png \"Hello Kitty\"");
		Link_Addr lin4 = new Link_Addr(lines4);
		
		Lines lines5 = new Lines();
		lines5.append("[kitty_2]:		C:\\kitty.png \"Hello Kitty\"");
		Link_Addr lin = new Link_Addr(lines5);
		
		
		for (int i = 0; i < id.size(); i++) {
			Ref_Img reImg = new Ref_Img(id.get(i));
			assertEquals(expected.get(i),reImg.generate());
		}
	}

}
