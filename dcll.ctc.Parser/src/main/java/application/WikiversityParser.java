/**
 * 
 */
package application;

import java.util.regex.Pattern;

import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.QuestionType;
import org.tsaap.questions.Quiz;
import org.tsaap.questions.impl.DefaultAnswer;
import org.tsaap.questions.impl.DefaultAnswerBlock;
import org.tsaap.questions.impl.DefaultQuestion;
import org.tsaap.questions.impl.DefaultQuiz;

/**
 * @author alpha oumar binta diallo
 *
 */
public class WikiversityParser implements Parser{
	
	private static final char CORRECT_ANSWER = '+';
	@SuppressWarnings("unused")
	private static final char BAD_ANSWER = '-';
	private static final String MULTIPLE_CHOICE = "[]";
	private static final String EXCLUSIVE_CHOICE = "()";
	private static final String QUESTION_TYPE_REG= "|type=\"";
	private static final String QUESTION_END_REG= "\"}\n";
	private static final String LINE_SEPARATOR = "\n";
	
	private String input = "";
	private Quiz quiz;
	
	/**
     * This method parses the input  and returns the generated quiz
     * @return Quiz
     */
	public Quiz parse() throws NoInputException, BadSyntaxException {
		// TODO Auto-generated method stub
		if(input.isEmpty()){
			throw new NoInputException("The Input is empty");
		}
		DefaultQuiz defQuiz = new DefaultQuiz();
		for (String str : splitQuestions()) {
			//Treatment
			checkInputFormat(str);
			DefaultQuestion question = new DefaultQuestion();
			question.setTitle(getQuestionTitle(str));
			question.setQuestionType(getQuestionType(str));
			question.addAnswerBlock(getAnswerBlock(str));
			defQuiz.addQuestion(question);
		}
		;		
		return quiz = defQuiz;
	}
	/**
     * This method return the quiz
     * @return Quiz
     */
	public Quiz getQuiz() {
		// TODO Auto-generated method stub
		return quiz;
	}
	/**
     * This method set the input of the parser.
     * @param String
     */
	public void setInput(String str) {
		// TODO Auto-generated method stub
		this.input = str;
	}
	/**
	 * This method split the input to separate several questions
	 * @return String array
	 */
	private String[] splitQuestions() {
		return input.split(LINE_SEPARATOR + LINE_SEPARATOR);
	}
	/**
	 * This method check the format of a input
	 * @throws BadSyntaxException
	 */
	private void checkInputFormat(String input) throws BadSyntaxException{
		String answerFormat = "[\\+-] (\\w|\\p{Punct})+";
		Pattern pAnswer = Pattern.compile("\\}"
				+ LINE_SEPARATOR
				+ "(" + answerFormat
				+ ""
				+ LINE_SEPARATOR
				+ ")*"
				+ answerFormat, Pattern.DOTALL);
		//line breaks are not significant Pattern.DOTALL
		Pattern pBraces = Pattern.compile("^\\{.*\\}", Pattern.DOTALL);
		Pattern ptype = Pattern.compile("\\|type=\"(\\(\\)|\\[\\])\"\\}");
		Pattern pQuestionText = Pattern.compile("\\{.+\\|", Pattern.DOTALL);
		
		//let's check the input
		if(!pBraces.matcher(input).find()){
			throw new BadSyntaxException("Format error, braces missing");
		}
		if(!ptype.matcher(input).find()){
			throw new BadSyntaxException("Format error, question type missing");
		}
		if(!pQuestionText.matcher(input).find()){
			throw new BadSyntaxException("Format error, question text missing");
		}
		if(!pAnswer.matcher(input).find()){
			throw new BadSyntaxException("Format error, invalid answers");
		}
		//is it there's a good answer?
		if(input.substring(input.indexOf("|type")).indexOf('+') < 0){
			throw new BadSyntaxException("Format error, A good answer is missing");
		}
	}
	/**
	 * This method return the question type
	 * @return QuestionType
	 */
	private QuestionType getQuestionType(String input){
		String type = input.substring(input.indexOf(QUESTION_TYPE_REG)
				+ QUESTION_TYPE_REG.length(), input.indexOf(QUESTION_END_REG));
		if(type.equals(EXCLUSIVE_CHOICE)) {
			return QuestionType.ExclusiveChoice;
		} else if(type.equals(MULTIPLE_CHOICE)) {
			return QuestionType.MultipleChoice;
		} else {
			return QuestionType.Undefined;
		}
	}
	/**
	 * This method return the title of the question
	 * @return String
	 */
	private String getQuestionTitle(String input){
		return input.substring(1, input.indexOf(QUESTION_TYPE_REG));
	}
	/**
	 * This method return the formatted AnswerBlock of the input
	 * @return AnswerBlock
	 */
	private AnswerBlock getAnswerBlock(String input){
		DefaultAnswerBlock answerBlock = new DefaultAnswerBlock();
		int correctAnswerNber = 0;
		//index of the end of the question
		String responseBlock = input.substring(input.indexOf(QUESTION_END_REG)
				+ QUESTION_END_REG.length());
		String[] response = responseBlock.split(LINE_SEPARATOR);
		//count the number of correct answers
		for (String str : response) {
			if(str.charAt(0) == CORRECT_ANSWER){
				correctAnswerNber++;
			}
		}
		//set the Answers block with percentage and delete (-,+)
		for (String str : response) {
			DefaultAnswer ans = new DefaultAnswer();
			ans.setTextValue(str.substring(2));
			if(str.charAt(0) == CORRECT_ANSWER){
				ans.setPercentCredit(1.0f/correctAnswerNber);
			}else{
				ans.setPercentCredit(0f);
			}
			answerBlock.addAnswer(ans);
		}
		
		return answerBlock;
	}

}
