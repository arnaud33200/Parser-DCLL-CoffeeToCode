/**
 * 
 */
package application.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.tsaap.questions.Answer;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Question;

/**
 * @author alpha oumar binta diallo
 *
 */
public class ExclusiveChoicePanel extends QuestionJPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ButtonGroup> bgroupList = new ArrayList<ButtonGroup>();

	public ExclusiveChoicePanel(Question question) {
		super(question);
		for(AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) {
			ButtonGroup group = new ButtonGroup();
			bgroupList.add(group);
			for(Answer ans : answerBlock.getAnswerList()) {
				JRadioButton radioButton = new JRadioButton(ans.getTextValue());
				group.add(radioButton);
				add(radioButton);
			}
		}
	}

	@Override
	public float compute() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void reset() {
		// TODO Auto-generated method stub
		for (ButtonGroup element : bgroupList) {
			element.clearSelection();
		}
	}

}
