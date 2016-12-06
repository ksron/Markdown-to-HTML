import static org.junit.Assert.*;

import org.junit.Test;

import Token.Emp_close;

public class Emp_closeTest {
	@Test
	public void testEmp_close() {
		Emp_close em = new Emp_close();
		assertEquals(em.generate(),"</em>");
	}
}
