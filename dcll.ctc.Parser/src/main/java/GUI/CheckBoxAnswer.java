package GUI;

import java.awt.Color;

import javax.swing.JCheckBox;

import org.tsaap.questions.Answer;

public class CheckBoxAnswer extends JCheckBox implements AnswerButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Answer answer;
	
	public CheckBoxAnswer(Answer a) {
		super(a.getTextValue());
		answer = a;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer a) {
		answer = a;
		
	}

	public float getCorrection() {
		float credit = answer.getPercentCredit(); 
		this.setOpaque(true);
		if( credit > 0 )
			this.setBackground(Color.green);
		else
			this.setBackground(Color.red);	
		this.setEnabled(false);
		return credit;
	}

	public void resetCorrection() {
		this.setBackground(null);
		this.setEnabled(true);
		this.setSelected(false);
	}
}
