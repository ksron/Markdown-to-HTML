import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Node.Code_Block;
import util.Lines;

public class Code_BlockTest {
	
	private static LinkedList<String> values;
	private static LinkedList<String> converted;
	 
	@BeforeClass
	public static void setUpList(){
		values = new LinkedList<String>();
		values.add("	This is a simple code block");
		values.add("	This is a simple code block with &");
		values.add("	This is a simple code block with <");
		values.add("	This is a simple code block with >");
		
		converted = new LinkedList<String>();
		converted.add("<pre><code>This is a simple code block</code></pre>");
		converted.add("<pre><code>This is a simple code block with &amp;</code></pre>");
		converted.add("<pre><code>This is a simple code block with &lt;</code></pre>");
		converted.add("<pre><code>This is a simple code block with &gt;</code></pre>");
	}
	@Test
	public void testCodeBlock() {
	     for(int i=0; i < values.size();i++)
	      {
	    	 Lines temp=new Lines();
	    	 temp.append(values.get(i));
	         Code_Block test_case = new Code_Block(temp);
	         assertEquals(test_case.generate(),converted.get(i));
	      }   
	}
}
