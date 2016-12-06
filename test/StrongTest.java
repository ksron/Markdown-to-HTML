import static org.junit.Assert.*;

import org.junit.Test;

import Token.Strong;

public class StrongTest {
	@Test
	public void testStrong() {
		Strong st = new Strong();
		assertEquals(st.generate(),"<strong>");
	}

}
