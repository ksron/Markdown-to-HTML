import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Hr;
import util.Lines;

public class HrTest {
	
	private static LinkedList<String> values;
	 
	@BeforeClass
	public static void setUpList(){
		values = new LinkedList<String>();
		values.add("----------");
		values.add("- - - -");
	}
	@Test
	public void testHeader() {
	     for(int i=0; i < values.size();i++)
	      {
	    	 Lines temp=new Lines();
	    	 temp.append(values.get(i));
	         Header test_case = new Header(temp);
	         assertEquals(test_case.generate(),"<hr>");
	      }   
	}
}
