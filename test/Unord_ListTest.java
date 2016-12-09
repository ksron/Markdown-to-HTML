import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Unord_List;
import util.Lines;

public class Unord_ListTest {

   private static LinkedList<String> values;
   private static LinkedList<String> converted;

   @BeforeClass
   public static void setUpList(){
      values = new LinkedList<String>();
      values.add("* A very simple\n* Unordered list");
      values.add("+ A very simple\n+ Unordered list");
      values.add("- A very simple\n- Unordered list");

      converted = new LinkedList<String>();
      converted.add("<ul><li>A very simple</li><li>Unordered list</li></ul>");
      converted.add("<ul><li>A very simple</li><li>Unordered list</li></ul>");
      converted.add("<ul><li>A very simple</li><li>Unordered list</li></ul>");
   }
   @Test
   public void testUnOrdList() {
        for(int i=0; i < values.size();i++)
         {
           Lines temp=new Lines();
           String temp_list[]=values.get(i).split("\n");
           temp.append(temp_list[0]);
           temp.append(temp_list[1]);

            Unord_List test_case = new Unord_List(temp);
            assertEquals(converted.get(i), test_case.generate());
         }
   }
}
