package org.tsaap.questions.impl;

import junit.framework.TestCase;

public class DefaultQuizTest extends TestCase{
	
	public void TestaddQuestion(){
		DefaultQuiz Q = new DefaultQuiz();
		DefaultQuestion k = new DefaultQuestion();
		Q.addQuestion(k);
		assertFalse(Q.getQuestionList().size()==0);
	}
	
	public void TestgetQuestionList(){
		DefaultQuiz Q = new DefaultQuiz();
		DefaultQuestion k = new DefaultQuestion();
		Q.addQuestion(k);
		assertNotNull(Q.getQuestionList());
	}

}
