package dcll.ctc.dcll.ctc.Parser.test;

import dcll.ctc.dcll.ctc.parser.NoInputException;
import junit.framework.TestCase;

public class NoInputExceptionTest extends TestCase {
	
	public void testNoInputException(){
		NoInputException bad1= new NoInputException();
		NoInputException bad2= new NoInputException("mamak");
		assertNotNull(bad1);
		assertNotNull(bad2);
		
	}
}
