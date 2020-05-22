package com.kg.beans;

import org.springframework.stereotype.Component;

// 스프링에서 빈 객체를 Component로 등록한 후 관리한다.
// root-context.xml에 등록할 수도 있고,
// @Component 어노테이션을 붙여놓고 스캔해서 사용하기도 한다.
@Component
public class User {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
