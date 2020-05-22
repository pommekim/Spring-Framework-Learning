package com.kg.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.kg.util.SubTest;

public class SubTest {
	
	Calculator c = new Calculator();
	private static final Logger log4j = org.apache.log4j.Logger.getLogger(SubTest.class);
	
	@Test
	public void testSub01() {
		for(int i=1; i<=10; i++) {
			
			int rnum1 = 0;
			int rnum2 = 0;
			int result = 0;
			
			for(int j=1; j<=1; j++) {
				rnum1 = (int) (Math.random()*101) + 1;
				rnum2 = (int) (Math.random()*101) + 1;
					
				result = c.sub(rnum1, rnum2);
				
				}
			log4j.info(rnum1 + "-" + rnum2 + "=" + result);
			
		}
	}
}

