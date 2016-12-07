import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Quoted_Block;
import util.Lines;

public class Quoted_BlockTest {
	
	private static LinkedList<String> values;
	private static LinkedList<String> converted;
	 
	@BeforeClass
	public static void setUpList(){
		values = new LinkedList<String>();
		values.add("> Blockquote Testing\n> Blockquote Testing\n> Blockquote Testing\n");
		
		converted = new LinkedList<String>();
		converted.add("<blockquote>Blockquote Testing\nBlockquote Testing\nBlockquote Testing</blockquote>");
	}
	@Test
	public void testQuotedBlock() {
	     for(int i=0; i < values.size();i++)
	      {
	    	 Lines temp=new Lines();
	    	 temp.append(values.get(i));
	         Quoted_Block test_case = new Quoted_Block(temp);
	         assertEquals(test_case.generate(),converted.get(i));
	      }   
	}
}
