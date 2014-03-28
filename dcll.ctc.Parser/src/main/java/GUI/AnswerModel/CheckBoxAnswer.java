package GUI.AnswerModel;

import java.awt.Color;

import javax.swing.JCheckBox;

import org.tsaap.questions.Answer;
/**
 * 
 * @author arnaud ladoucette
 *
 */
public class CheckBoxAnswer extends JCheckBox implements AnswerButton {

	private static final long serialVersionUID = 1L;
	private Answer answer;
	
	public CheckBoxAnswer(Answer answer) {
		super(answer.getTextValue());
		this.answer = answer;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
		
	}

	public float getCorrection() {
		float credit = answer.getPercentCredit(); 
		this.setOpaque(true);
		if( credit > 0 ){
			this.setBackground(Color.green);
		}else{
			this.setBackground(Color.red);	
		}	
		this.setEnabled(false);
		return credit;
	}

	public void resetCorrection() {
		this.setBackground(null);
		this.setEnabled(true);
		this.setSelected(false);
	}
}
