import static org.junit.Assert.*;

import org.junit.Test;

import Token.Code_close;
import Token.Token;

public class Code_closeTest {

	@Test
	public void testCode_close() {
		Code_close cl = new Code_close();
		assertEquals(cl.generate(),"</code>");
	}

}
