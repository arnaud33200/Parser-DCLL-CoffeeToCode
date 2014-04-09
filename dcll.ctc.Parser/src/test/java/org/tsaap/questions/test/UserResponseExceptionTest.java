package org.tsaap.questions.test;

import org.tsaap.questions.UserResponseException;

import junit.framework.TestCase;

public class UserResponseExceptionTest extends TestCase{
	
	public void testUserResponseException(){
		UserResponseException u= new UserResponseException("hey");
		assertNotNull(u);
	}

}
