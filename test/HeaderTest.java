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
		
		converted = new LinkedList<String>();
		converted.add("<h1>A simple h1 header</h1>");
		converted.add("<h2>A simple h2 header</h2>");
		converted.add("<h3>A simple h3 header</h3>");
		converted.add("<h2>A simple h2 header</h2>");
	}
	@Test
	public void testHeader() {
	     for(int i=0; i < values.size();i++)
	      {
	    	 Lines temp=new Lines();
	    	 temp.append(values.get(i));
	         Header test_case = new Header(temp);
	         assertEquals(test_case.generate(),converted.get(i));
	      }   
	}
}
