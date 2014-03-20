package org.tsaap.questions.impl;

import junit.framework.TestCase;

public class DefaultAnswerTest extends TestCase {
	
	public void Testequals(){
		Object g = null;
		assertFalse(equals(g));
	}
	
	public void TesthashCode(){
		DefaultAnswer a = new DefaultAnswer();
		assertTrue(a.hashCode()==(a.getIdentifier().hashCode()));
	}
}
