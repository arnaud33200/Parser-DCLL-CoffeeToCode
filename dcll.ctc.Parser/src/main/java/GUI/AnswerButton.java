package GUI;

import org.tsaap.questions.Answer;

public interface AnswerButton {
	
	public Answer getAnswer();
	
	public void setAnswer(Answer a);
	
	public float getCorrection();
	
	public void resetCorrection();
}
