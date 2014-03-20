package org.tsaap.questions.impl;

import junit.framework.TestCase;

public class DefaultUserAnswerBlockTest extends TestCase{
	
	public void TestgetAnswerList(){
		DefaultUserAnswerBlock U = new DefaultUserAnswerBlock();
		assertNull(U.getAnswerList());
	}
	
	public void TestevaluatePercentCredit(){
		DefaultUserAnswerBlock U = new DefaultUserAnswerBlock();
		Float r = U.evaluatePercentCredit();
		assertTrue(r==0);
	}
}
