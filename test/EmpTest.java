import static org.junit.Assert.*;

import org.junit.Test;
import Token.Emp;
public class EmpTest {
	@Test
	public void test() {
		Emp emp = new Emp();
		assertEquals(emp.generate(),"<em>");
	}
}
