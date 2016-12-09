import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Header;
import util.Lines;

public class HeaderTest {

   private static LinkedList<String> values;
   private static LinkedList<String> converted;

   @BeforeClass
   public static void setUpList(){

      values = new LinkedList<String>();
      values.add("A simple h1 header\n===========");
      values.add("A simple h2 header\n-----------");
      values.add("### A simple h3 header");
      values.add("## A simple h2 header");
      values.add(" ######## A simple h6 header");

      converted = new LinkedList<String>();
      converted.add("<h1>A simple h1 header</h1>\n");
      converted.add("<h2>A simple h2 header</h2>\n");
      converted.add("<h3>A simple h3 header</h3>\n");
      converted.add("<h2>A simple h2 header</h2>\n");
      converted.add("<h6>A simple h6 header</h6>\n");
   }
   @Test
   public void testHeader() {
        for(int i=0; i < values.size();i++)
         {
           Lines temp=new Lines();
           if(values.get(i).contains("=")||values.get(i).contains("-")){
              temp.append(values.get(i).split("\n")[0]);
              temp.append(values.get(i).split("\n")[1]);
           }else
              temp.append(values.get(i));
            Header test_case = new Header(temp);
            assertEquals(converted.get(i),test_case.generate());
         }
   }
}
