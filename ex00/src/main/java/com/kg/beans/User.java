package com.kg.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

// 스프링에서 빈 객체를 Component로 등록한 후 관리한다.
// root-context.xml에 등록할 수도 있고,
// @Component 어노테이션을 붙여놓고 스캔해서 사용하기도 한다.
@Component
public class User {
	
	private String name;
	private int age;
	// 바인딩 정책과 비슷한 역할을 하는 어노테이션 @DateTimeFormat
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
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
