
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Link_Addr;
import Token.Implicit;
import util.Lines;

public class ImplicitTest {

	private static LinkedList<String> id;
	private static LinkedList<String> expected;

	@BeforeClass
	public static void setUpList() {

		id = new LinkedList<String>();
		id.add("[an example][]");
		id.add("[an example1][]");
		id.add("[an example2][]");
		id.add("[text][1]");
		id.add("[null Test][a]");

		expected = new LinkedList<String>();
		expected.add("<a href= \"http://example.com/\" title = \"Title\">an example</a>");
		expected.add("<a href= \"http://example.com/\" title = \"Title1\">an example1</a>");
		expected.add("<a href= \"http://example.com/\" title = \"Title2\">an example2</a>");
		expected.add("<a href= \"/path/to/source.html\">text</a>");
		expected.add("[null Test][a]");
	}

	@Test
	public void testGenerate() {
		Lines lines1 = new Lines();
		lines1.append("[an example]: http://example.com/ \"Title\"");
		Link_Addr lin1 = new Link_Addr(lines1);

		Lines lines2 = new Lines();
		lines2.append("[an example2]:  http://example.com/ (Title2)");
		Link_Addr lin2 = new Link_Addr(lines2);

		Lines lines3 = new Lines();
		lines3.append("[an example1]:  http://example.com/ \'Title1\'");
		Link_Addr lin3 = new Link_Addr(lines3);

		Lines lines4 = new Lines();
		lines4.append("[text]:	\\path\\to\\source.html");
		Link_Addr lin4 = new Link_Addr(lines4);

		for (int i = 0; i < id.size(); i++) {
			Implicit im = new Implicit(id.get(i));
			assertEquals(expected.get(i), im.generate());
		}
	}

}
