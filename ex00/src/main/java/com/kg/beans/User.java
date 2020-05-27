package com.kg.beans;

import java.text.SimpleDateFormat;
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
	
	// toString()을 오버라이드 하면 이 객체가 문자열로 표현될 때 어떻게 표현될지 설정할 수 있다.
	@Override
	public String toString() {
//		return super.toString(); //자기 주소를 찍어주는 기본 toString()
		
		SimpleDateFormat dateForm = new SimpleDateFormat("yy년 MM월 dd일");
		String date = dateForm.format(joinDate);

		return String.format("가입일 : %s<br>이름 : %s<br>나이 : %d<br>", date, name, age);
		//date자리에 joinDate.toString()도 사용 가능!!!
	}
	
	
	// hashCode는 객체의 고유 번호 (주소값 아님)
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	
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
