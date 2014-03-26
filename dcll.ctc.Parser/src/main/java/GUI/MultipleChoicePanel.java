/**
 * 
 */
package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import org.tsaap.questions.Answer;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Question;

/**
 * @author alpha oumar binta diallo
 *
 */
public class MultipleChoicePanel extends QuestionJPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CheckBoxAnswer> checkboxList = new ArrayList<CheckBoxAnswer>();

	public MultipleChoicePanel(Question question) {
		super(question);
		for(AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) { 
			for(Answer ans : answerBlock.getAnswerList()) {
				CheckBoxAnswer checkbox = new CheckBoxAnswer(ans);
				add(checkbox);
				checkboxList.add(checkbox);
			}
		}
	}

	@Override
	public float compute() {
		float credit = 0;
		for (CheckBoxAnswer ans : checkboxList) {
			float creditans = ans.getCorrection();
			if( ans.isSelected())
				credit += creditans;
		}
		return credit;
	}

	@Override
	public void reset() {
		for (CheckBoxAnswer ans : checkboxList) {
			ans.resetCorrection();
		}
	}

}
