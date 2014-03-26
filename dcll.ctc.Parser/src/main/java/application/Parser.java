/**
 * 
 */
package application;
import org.tsaap.questions.Quiz;

/**
 * @author alpha oumar binta diallo
 * 
 * Parser is the interface that allows to analyze a Question
 * */

public interface Parser {
	
	/**
     * This method parses the input  and returns the generated quiz
     * @return Quiz
     */
	public Quiz parse() throws NoInputException, BadSyntaxException;
	/**
     * This method set the input of the parser.
     * @param String
     */
	public void setInput(String str);
	
	/**
     * This method return the quiz
     * @return Quiz
     */
    public Quiz getQuiz();
}
