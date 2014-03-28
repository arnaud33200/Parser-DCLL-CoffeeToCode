/**
 * 
 */
package dcll.ctc.dcll.ctc.Parser;

/**
 * @author alpha oumar binta diallo
 *
 */
public class BadSyntaxException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadSyntaxException() {
	}

	/**
	 * @param message
	 */
	public BadSyntaxException(String message) {
		super(message);
	}
}
