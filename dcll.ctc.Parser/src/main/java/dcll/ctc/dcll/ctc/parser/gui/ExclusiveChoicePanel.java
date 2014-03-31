package dcll.ctc.dcll.ctc.parser.gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import org.tsaap.questions.Answer;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Question;

import dcll.ctc.dcll.ctc.parser.gui.model.RadioButtonAnswer;

/**
 * @author alpha oumar binta diallo
 */
public class ExclusiveChoicePanel extends QuestionJPanel {
    private List<ButtonGroup> bgroupList = new ArrayList<ButtonGroup>();
    private List<RadioButtonAnswer> radioList = new ArrayList<RadioButtonAnswer>();

    public ExclusiveChoicePanel(Question question) {
        super(question);
        for (AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) {
            ButtonGroup group = new ButtonGroup();
            bgroupList.add(group);
            for (Answer ans : answerBlock.getAnswerList()) {
                RadioButtonAnswer radioButton = new RadioButtonAnswer(ans);
                group.add(radioButton);
                radioList.add(radioButton);
                add(radioButton);
            }
        }
    }

    @Override
    public float compute() {
        float credit = 0;
        for (RadioButtonAnswer ans : radioList) {
            float creditans = ans.getCorrection();
            if (ans.isSelected())
                credit += creditans;
        }
        return credit;
    }

    public void reset() {
        for (ButtonGroup element : bgroupList) {
            element.clearSelection();
        }
        for (RadioButtonAnswer ans : radioList) {
            ans.resetCorrection();
        }
    }

}
