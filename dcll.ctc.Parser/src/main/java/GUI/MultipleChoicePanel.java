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
	private List<JCheckBox> checkboxList = new ArrayList<JCheckBox>();

	public MultipleChoicePanel(Question question) {
		super(question);
		for(AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) { 
			for(Answer ans : answerBlock.getAnswerList()) {
				JCheckBox checkbox = new JCheckBox(ans.getTextValue());
				add(checkbox);
				checkboxList.add(checkbox);
			}
		}
	}

	@Override
	public float compute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		for (JCheckBox element : checkboxList) {
			element.setSelected(false);
		}
	}

}
