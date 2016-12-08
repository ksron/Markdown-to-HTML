import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Ord_List;
import util.Lines;

public class Ord_ListTest {
	
	private static LinkedList<String> values;
	private static LinkedList<String> converted;
	 
	@BeforeClass
	public static void setUpList(){
		values = new LinkedList<String>();
		values.add("1. This is a\n2. Very simple\n3. Ordered list.");
		values.add("4. This is a\n8. Very simple\n1. Ordered list.");
		
		converted = new LinkedList<String>();
		converted.add("<ol><li>This is a</li><li>Very simple</li><li>Ordered list.</li></ol>");
		converted.add("<ol><li>This is a</li><li>Very simple</li><li>Ordered list.</li></ol>");
	}
	@Test
	public void testOrdList() {
	     for(int i=0; i < values.size();i++)
	      {
	    	 Lines temp=new Lines();
	    	 String temp_list[]=values.get(i).split("\n");
	    	 temp.append(temp_list[0]);
	    	 temp.append(temp_list[1]);
	    	 temp.append(temp_list[2]);
	    	 Ord_List test_case = new Ord_List(temp);
	         assertEquals(test_case.generate(),converted.get(i));
	      }   
	}
}
