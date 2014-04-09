package org.tsaap.questions.test;

import org.tsaap.questions.QuestionType;

import junit.framework.TestCase;

public class QuestionTypeTest extends TestCase{
	
	public void testgetCode(){
		QuestionType q = QuestionType.FillInTheBlank;
		int code=q.getCode();
		assertNotNull(code);
	}
}
