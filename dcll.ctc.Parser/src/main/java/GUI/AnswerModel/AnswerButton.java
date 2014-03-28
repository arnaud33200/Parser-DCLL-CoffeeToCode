package GUI.AnswerModel;

import org.tsaap.questions.Answer;
/**
 * 
 * @author arnaud ladoucette
 *
 */
public interface AnswerButton {
	
	public Answer getAnswer();
	
	public void setAnswer(Answer answer);
	
	public float getCorrection();
	
	public void resetCorrection();
}
