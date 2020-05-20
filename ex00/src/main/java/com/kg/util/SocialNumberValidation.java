package com.kg.util;

public class SocialNumberValidation {
	
	// XXXXXX-XXXXXXX
	public static boolean validate(String socialNumber) {
		String[] numbers = socialNumber.split("-");
		char gender = numbers[1].charAt(0);
		
		if(numbers.length != 2) {
			return false;
		} else if(!(gender == '1' || gender == '2' || gender == '3' || gender == '4')) {
			return false;
		}
		
		return true;
	}

}
