import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Token.Auto;

public class AutoTest {
	
	private static LinkedList<String> values;
	private static LinkedList<String> converted;
	 
	@BeforeClass
	public static void setUpList(){
		values = new LinkedList<String>();
		values.add("<http://example.com/>");
		values.add("<address@example.com>");
		
		converted = new LinkedList<String>();
		converted.add("<a href=\"http://example.com/\">http://example.com/</a>");
		converted.add("<a href=\"mailto:address@example.com\">address@example.com</a>");
	}
	@Test
	public void testAuto() {
	     for(int i=0; i < values.size();i++)
	      {
	         Auto auto = new Auto(values.get(i));
	         assertEquals(auto.generate(),converted.get(i));
	      }   
	}
}
