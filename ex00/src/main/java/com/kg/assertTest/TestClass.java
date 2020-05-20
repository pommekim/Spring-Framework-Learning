package com.kg.assertTest;

import java.util.ArrayList;

public class TestClass {
	
	// assertEquals() 이외의 assert 메서드로 테스트 할 수 있는 기능을 이곳에 하나 구현하고
	// 테스트 클래스를 생성한 뒤 JUnit Test를 진행해보세요.
	
	ArrayList<String> list = new ArrayList<>();
	
	public void insertName(String name) {
		list.add(name);
	}
	
	
	
}


