

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Link_Addr;
import Token.Ref;
import util.Lines;

public class RefTest {

   private static LinkedList<String> id;
   private static LinkedList<String> expected;

   @BeforeClass
   public static void setUpList() {
      Link_Addr lin_main = new Link_Addr(new Lines());
      lin_main.removeList();

      id = new LinkedList<String>();
      id.add("[an example][id]");
      id.add("[an example1][id1]");
      id.add("[an example2][id2]");
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
      lines1.append("[id]: http://example.com/ \"Title\"");
      Link_Addr lin1 = new Link_Addr(lines1);

      Lines lines2 = new Lines();
      lines2.append("[id2]:  http://example.com/ (Title2)");
      Link_Addr lin2 = new Link_Addr(lines2);

      Lines lines3 = new Lines();
      lines3.append("[id1]:  http://example.com/ \'Title1\'");
      Link_Addr lin3 = new Link_Addr(lines3);

      Lines lines4 = new Lines();
      lines4.append("[1]:   \\path\\to\\source.html");
      Link_Addr lin4 = new Link_Addr(lines4);

      for (int i = 0; i < id.size(); i++) {
         Ref re = new Ref(id.get(i));
         assertEquals(expected.get(i), re.generate());
      }

   }
}