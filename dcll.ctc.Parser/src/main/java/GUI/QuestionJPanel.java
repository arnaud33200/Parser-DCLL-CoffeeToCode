/**
 * 
 */
package GUI;
import org.tsaap.questions.Question;
import javax.swing.BorderFactory;

/**
 * @author alpha oumar binta diallo
 *
 */
public abstract class QuestionJPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question;

	/**
     * Creates new form QuestionJPanel
     * @param question
     */
    public QuestionJPanel(Question question) {
    	this.question = question;
    	setBorder(BorderFactory.createTitledBorder(question.getTitle()));
    }
    /**
     * this method return the question
     * @return Question
     */
	protected Question getQuestion() {
		return question;
	}
	/**
	 * this method calculate the score made by the user
	 * @return float
	 */
	public abstract float compute();
	/**
	 * this method reset the Question panel
	 */
	public abstract void reset();
}