import static org.junit.Assert.*;

import org.junit.Test;

import Token.Strong_close;

public class Strong_closeTest {

	@Test
	public void testStrong_close() {
		Strong_close sc = new Strong_close();
		assertEquals(sc.generate(),"</strong>");
	}

}
