import static org.junit.Assert.*;
import mdconverter.MDConverter;
import org.junit.Test;

public class MDconverterTest {

	@Test
	public void testMain() {
		MDConverter.main(new String[] {"header_test.md"});
	}

}
