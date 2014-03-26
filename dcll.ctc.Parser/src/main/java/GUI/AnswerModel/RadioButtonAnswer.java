package GUI.AnswerModel;

import java.awt.Color;

import javax.swing.JRadioButton;

import org.tsaap.questions.Answer;

public class RadioButtonAnswer extends JRadioButton implements AnswerButton {

	private Answer answer;
	
	public RadioButtonAnswer(Answer a) {
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
