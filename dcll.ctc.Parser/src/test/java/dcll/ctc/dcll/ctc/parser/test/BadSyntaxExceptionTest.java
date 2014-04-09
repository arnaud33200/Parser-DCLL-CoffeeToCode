package dcll.ctc.dcll.ctc.Parser.test;

import junit.framework.TestCase;
import dcll.ctc.dcll.ctc.parser.BadSyntaxException;

public class BadSyntaxExceptionTest extends TestCase{
	
	public void testBadSyntaxException(){
		BadSyntaxException bad1= new BadSyntaxException();
		BadSyntaxException bad2= new BadSyntaxException("mamak");
		assertNotNull(bad1);
		assertNotNull(bad2);
	}

}
