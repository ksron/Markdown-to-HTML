import static org.junit.Assert.*;
import mdconverter.MDConverter;
import org.junit.Test;
import java.util.LinkedList;

public class MDconverterTest {


	@Test
	public void testMain() {
		MDConverter.main(new String[] {"README_test.md","-o","systemtest","-f","html","-s","plain","-d","./"});
//AutoTest autotest = new AutoTest();
//CodeTest cct = new CodeTest();
//Code_BlockTest ct = new Code_BlockTest();
//Code_closeTest cc = new Code_closeTest();

	}
}
