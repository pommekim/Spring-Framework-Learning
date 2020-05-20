package com.kg.util;

import java.util.HashSet;

public class ExistEmail {
	
	static HashSet<String> emailSet = new HashSet<>();
	
	// 이미 존재하는 이메일이라면 false를 리턴하고,
	// 아직 등록되지 않은 이메일이라면 emailSet에 추가한 뒤 true를 리턴한다.
	public static boolean check(String newMail) {
		
		//쌤이한거
		// Set.add() : 중복되는 값은 추가가 되지 않으며 false를 리턴한다.
		// 중복되는 값이 없어서 추가에 성공했다면 true를 리턴한다.
		return emailSet.add(newMail); //add메서드가 이미 true, false를 반환하기 때문에 한 줄로 끝.
		
//		if(emailSet.contains(newMail)) {
//			return false;
//		} else {
//			emailSet.add(newMail);
//			return true;
//		}
	}
	// 구현이 끝난 뒤 알맞은 JUnit 테스트 프로그램을 작성해보세요.
	
}
