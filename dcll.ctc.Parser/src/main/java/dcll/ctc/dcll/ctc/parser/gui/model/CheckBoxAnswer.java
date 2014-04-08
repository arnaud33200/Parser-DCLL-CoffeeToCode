package dcll.ctc.dcll.ctc.parser.gui.model;

import java.awt.Color;

import javax.swing.JCheckBox;

import org.tsaap.questions.Answer;

/**
 * @author arnaud ladoucette
 */
@SuppressWarnings("serial")
public class CheckBoxAnswer extends JCheckBox implements AnswerButton {

    /**
     * an answer.
     */
    private Answer answer;
    /**
     * constructor with an answer.
     * @param ans the answer to set
     */
    public CheckBoxAnswer(final Answer ans) {
        super(ans.getTextValue());
        this.answer = ans;
    }
    /**
     * @return Answer the answer.
     */
    public Answer getAnswer() {
        return answer;
    }
    /**
     * @param ans the Answer to set.
     */
    public void setAnswer(final Answer ans) {
        this.answer = ans;

    }
    /**
     * @return float the result of a question.
     */
    public float getCorrection() {
        float credit = answer.getPercentCredit();
        this.setOpaque(true);
        if (credit > 0) {
            this.setBackground(Color.green);
        } else {
            this.setBackground(Color.red);
        }
        this.setEnabled(false);
        return credit;
    }
    /**
     * reset the answer of  question.
     */
    public void resetCorrection() {
        this.setBackground(null);
        this.setEnabled(true);
        this.setSelected(false);
    }
}
