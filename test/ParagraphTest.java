import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Paragraph;
import util.Lines;

public class ParagraphTest {

   private static LinkedList<String> values;
   private static LinkedList<String> converted;

   @BeforeClass
   public static void setUpList(){
      values = new LinkedList<String>();
      values.add("A Simple Paragraph Testing");

      converted = new LinkedList<String>();
      converted.add("<p>A Simple Paragraph Testing</p>\n");
   }
   @Test
   public void testParagraph() {
        for(int i=0; i < values.size();i++)
         {
           Lines temp=new Lines();
           temp.append(values.get(i));
            Paragraph test_case = new Paragraph(temp);
            assertEquals(test_case.generate(),converted.get(i));
         }
   }
}