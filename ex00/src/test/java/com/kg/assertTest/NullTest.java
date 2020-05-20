package com.kg.assertTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NullTest {
	
	TestClass t = new TestClass();
	
	@Test
	public void testNull01() {
		t.insertName("김지영");
		
		assertNotNull(t);
		
	}

}
