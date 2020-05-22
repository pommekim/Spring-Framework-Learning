package com.kg.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;

import java.util.Random;

public class SubTestQuiz {
	
	// 이 클래스에서 발생하는 로그를 Appender에게 전달할 Logger를 생성해야 한다. (이 클래스만 쓰면 되기 때문에 private)
	private static Logger logger = Logger.getLogger(SubTestQuiz.class);
	
	// @Test를 등록하면 JUnit이 알아서 찾아서 실행해준다.
	@Test
	public void subMethodTest() {
		Calculator c = new Calculator();
		
		// 랜덤 클래스의 인스턴스를 생성하면 매번 새로운 시드가 생성된다.
		Random r = new Random();
		
		for(int i=0; i<10; i++) {
			// 0부터 9999 사이의 랜덤 숫자 두개를 생성해 테스트에 사용한다.
			int a = r.nextInt(10000); //바운더리 정해주기
			int b = r.nextInt(10000);
			int result = c.sub(a, b);
			
			assertEquals(a - b, result);
			
			// Logger에 로그를 쓰면 Logger에 등록된 Appender가 가리키는 곳에 로그를 추가한다.
			logger.warn(String.format("%d - %d = %d", a, b, result));
		}

		
	}
	

}
