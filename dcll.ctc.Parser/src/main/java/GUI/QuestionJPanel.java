/**
 * 
 */
package GUI;
import javax.swing.BorderFactory;

import org.tsaap.questions.Question;

/**
 * @author alpha oumar binta diallo
 *
 */
public abstract class QuestionJPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private Question question;

	/**
     * Creates new form QuestionJPanel
     * @param question
     */
    public QuestionJPanel(Question question) {
    	this.question = question;
    	this.setBorder(BorderFactory.createTitledBorder(question.getTitle()));
    	this.setSize(getPreferredSize());
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