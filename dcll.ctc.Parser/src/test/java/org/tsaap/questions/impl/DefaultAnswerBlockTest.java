package org.tsaap.questions.impl;

import junit.framework.TestCase;

public class DefaultAnswerBlockTest extends TestCase{
	
	public void TestaddAnswer(){
		DefaultAnswerBlock d=new DefaultAnswerBlock();
		DefaultAnswer an = new DefaultAnswer();
		d.addAnswer(an);
		assertFalse(d.getAnswerList().size()==0);
	}
}
