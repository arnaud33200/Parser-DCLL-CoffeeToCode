package org.tsaap.questions.impl;

import junit.framework.TestCase;

import org.tsaap.questions.TextBlock;

public class DefaultQuestionTest extends TestCase{
	
	public void TestaddAnswerBlock(){
		DefaultAnswerBlock fragment = new DefaultAnswerBlock();
		DefaultQuestion Q= new DefaultQuestion();
		Q.addAnswerBlock(fragment);
		assertFalse(Q.getBlockList().size()==0);
		assertFalse(Q.getAnswerBlockList().size()==0);
	}
	
	public void TestaddTextBlock(){
		TextBlock fragment =null;
		DefaultQuestion Q= new DefaultQuestion();
		Q.addTextBlock(fragment);
		assertFalse(Q.getBlockList().size()==0);
		assertFalse(Q.getTextBlockList().size()==0);

	}

}
