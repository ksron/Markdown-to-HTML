import static org.junit.Assert.*;

import org.junit.Test;

import Token.Code;

public class CodeTest {
	@Test
	public void testCode() {
		Code code = new Code();
		assertEquals(code.generate(),"<code>");
	}
}
