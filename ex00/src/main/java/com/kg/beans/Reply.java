package com.kg.beans;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Reply {
	
	private User user;
	private String comment;
	private Timestamp timestamp;
	private String password;
	
	//스프링이 알아서 관리해줌
//	public Reply(String name, int age, String comment, Timestamp timestamp, String password) {
//		
//	}
	
	public User getUser() {
		return user;
	}
	//스프링이 자동으로 생성해줌
	@Autowired
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
