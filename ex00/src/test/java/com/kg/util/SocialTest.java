package com.kg.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SocialTest {
	
	@Test
	public void socialNumberTest() {
		String case1 = "123456-1234567"; // 정상 케이스
		String case2 = "123456-4234567"; // 성별 번호를 일부러 틀린 케이스
		String case3 = "123456-12345-67123"; // -를 여러개 넣은 케이스
		
		assertTrue(SocialNumberValidation.validate(case1));
		assertFalse(SocialNumberValidation.validate(case2));
		assertFalse(SocialNumberValidation.validate(case3));
		
	}

}
