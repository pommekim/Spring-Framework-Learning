package com.kg.beans;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	private List<User> list;
	
	//기본 생성자
	public UserList() {
		list = new ArrayList<>();
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	

}
