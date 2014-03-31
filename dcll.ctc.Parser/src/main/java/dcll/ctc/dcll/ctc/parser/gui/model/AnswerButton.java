package dcll.ctc.dcll.ctc.parser.gui.model;

import org.tsaap.questions.Answer;

/**
 * @author arnaud ladoucette
 */
public interface AnswerButton {

    /**
     * @return Answer the answer.
     */
    Answer getAnswer();
    /**
     * @param answer the Answer to set.
     */
    void setAnswer(Answer answer);
    /**
     * @return float the result of a question.
     */
    float getCorrection();
    /**
     * reset the answer of  question.
     */
    void resetCorrection();
}
