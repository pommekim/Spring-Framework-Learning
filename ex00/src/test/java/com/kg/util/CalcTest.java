package com.kg.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcTest {
	
	Calculator c = new Calculator();
	
	@Test //테스트임을 명시 (junit에서 import해야 함)
	public void testSum01() {
		int result = c.sum(99, 999);
		//기대하고 있는 값과 실제 값이 같으면 테스트 통과!!!
		// expected : 기대하는 값
		// actual : 실제 테스트하는 프로그램의 연산
		// delta : 허용 범위
		assertEquals(99 + 998, result, 5);
		//우클릭 - run as - junit test
	}
	
	@Test
	public void testSum02() {
		//오차 범위까지 설정해 줄 수 있음!!!
		assertEquals(1050, c.sum(900, 100), 100);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
