package org.tsaap.questions.test;

import junit.framework.TestCase;

import org.tsaap.questions.QuizReaderException;

public class QuizReaderExceptionTest extends TestCase{
	
	public void testQuizReaderException(){
		QuizReaderException u= new QuizReaderException("hey");
		assertNotNull(u);
	}

}
