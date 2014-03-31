package dcll.ctc.dcll.ctc.parser.gui.model;

import java.awt.Color;

import javax.swing.JRadioButton;

import org.tsaap.questions.Answer;

/**
 * @author arnaud ladoucette
 */
@SuppressWarnings("serial")
public class RadioButtonAnswer extends JRadioButton implements AnswerButton {

    /**
     * an answer.
     */
    private Answer answer;
    /**
     * constructor with an answer.
     * @param ans the answer to set
     */
    public RadioButtonAnswer(final Answer ans) {
        super(ans.getTextValue());
        this.answer = ans;
    }
    /**
     * @return Answer the answer.
     */
    public final Answer getAnswer() {
        return answer;
    }
    /**
     * @param ans the Answer to set.
     */
    public final void setAnswer(final Answer ans) {
        this.answer = ans;
    }
    /**
     * @return float the result of a question.
     */
    public final float getCorrection() {
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
    public final void resetCorrection() {
        this.setBackground(null);
        this.setEnabled(true);
        this.setSelected(false);
    }

}
