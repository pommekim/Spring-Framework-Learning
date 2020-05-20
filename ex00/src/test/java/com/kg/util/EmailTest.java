package com.kg.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailTest {
	
//	@Test
//	public void EmailExistTest() {
//		
//		String case1 = "abc1234@gmail.com"; //정상 이메일
//		String case2 = "aaa1111@gmail.com"; //새로운 이메일 (true가 떠야 함)
//		
//		assertTrue(ExistEmail.check(case1));
//		assertFalse(ExistEmail.check(case1)); //중복 된 이메일 (false가 떠야 함)
//		assertTrue(ExistEmail.check(case2));
//		
//	}
	
	
	
	//쌤이한거
	@Test
	public void emailDupleTest01() {
		String[] emails = {"abc1234@gmail.com", "abc1234@naver.com", "abc1234@daum.net"};
		
		for(String email : emails) assertTrue(ExistEmail.check(email));
		
		for(String email : emails) assertFalse(ExistEmail.check(email));
		
	}

	

}
