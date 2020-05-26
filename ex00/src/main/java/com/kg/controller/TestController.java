package com.kg.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kg.beans.User;
import com.kg.beans.UserList;
import com.kg.util.Animal;

// @Controller : 이 클래스가 컨트롤러임을 스프링에게 알린다. (이 클래스를 스프링이 관리한다.)
// @RequestMapping : 이 컨트롤러에 찾아올 수 있는 URL을 맵핑한다.

@Controller
@RequestMapping("/test/*")
public class TestController {
	
	private static Logger log = Logger.getLogger(TestController.class);
	
	// 이곳에 접속할 수 있는 url : /test/
	@RequestMapping("/")
	public void index() {
		log.info("새로운 사용자가 /test/로 요청을 보냈습니다.");
	}
	
	// 이곳에 접속할 수 있는 url : /test/photo
	@RequestMapping("photo")
	public void gallery() {
		log.info("새로운 사용자가 /test/photo로 요청을 보냈습니다.");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public void methodTest() {
		log.info("GET 방식으로 /test/method에 요청하면 이곳에 도착한다.");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public void methodTest2() {
		log.info("POST 방식으로 /test/method에 요청하면 이곳에 도착한다.");
	}
	
	@RequestMapping(value="/param", method={RequestMethod.GET, RequestMethod.POST})
	public void paramTest(Animal pet) {
		// JSP였다면...
		// String name = request.getParameter("name");
		// int age = Integer.parseInt(request.getParameter("age"));
		
		// Spring의 컨트롤러는 DispatcherServlet에서 알아서 파라미터들을 받은 뒤
		// 이 컨트롤러에 사용하기 편한 형태로 넘겨준다. (데이터 자동 수집, 바인딩)
		log.info("전달받은 이름: " + pet.getName());
		log.info("전달받은 나이: " + pet.getAge());
	}
	
	// http://localhost:8080/controller/test/param2?name=aaa&age=123
	@RequestMapping(value="/param2", method=RequestMethod.GET)
	public void paramTest2(
			@RequestParam("name") String n,
			@RequestParam("age") int a
			) {
		// @RequestParam을 이용해 함수의 매개변수로 파라미터 받아오기
		log.info("n : " + n);
		log.info("a : " + a);
	}
		
	// http://localhost:8080/controller/test/param3?name=aaa&age=123
	@RequestMapping(value="/param3", method=RequestMethod.GET)
	public void paramTest3(String name, int age) {
		// 요청 파라미터 이름과 함수 매개변수명이 일치한다면
		// @RequestParam 어노테이션 없이도 값이 바인딩된다.
		log.info("param3 name : " + name);
		log.info("param3 age : " + age);
	}
	
	// http://localhost:8080/controller/test/list1?hobbies=soccer&hobbies=football&hobbies=movie
	@RequestMapping("/list1")
	public void list1(@RequestParam("hobbies") ArrayList<String> hobbies) {
		// 동일한 이름의 파라미터가 여러개 전달되는 경우
		// ArrayList<> 타입을 이용해 자동으로 수집할 수 있다.
		log.info("취미들: " + hobbies);
	}
	
	// http://localhost:8080/controller/test/list2?foods=meat&foods=ramen&foods=chicken
	@RequestMapping("/list2")
	public void list2(@RequestParam("foods") String[] foods) {
		// 동일한 이름의 파라미터 여러개를 배열로 받을 수도 있다.
		log.info("음식들: " + Arrays.toString(foods));
	}
	
	
	// http://localhost:8080/controller/test/beans
	// ?list[0].name=aaa&list[0].age=1&list[1].name=bbb&list[1].age=2
	// ※GET방식 요청을 할 때 []는 그냥 사용할 수가 없다.
	// [ : %5B로 치환
	// ] : %5D로 치환해서 주소에 입력
	@RequestMapping("/beans")
	public void javaBeans(UserList list) {
		// 알아서 바인딩이 모두 되어있음
		log.info("user[0].name: " + list.getList().get(0).getName());
		log.info("user[1].name: " + list.getList().get(1).getName());
	}
	
	
	// http://localhost:8080/controller/test/join?joinDate=2020/05/26&name=aa&age=11
	@RequestMapping("/join")
	public void join(User user) {
		log.info("이름: " + user.getName());
		log.info("나이: " + user.getAge());
		log.info("가입일: " + user.getJoinDate());
	}
	
//	// http://localhost:8080/controller/test/join?joinDate=2020.05.26&name=aa&age=11
//	// 모든 요청이 바인딩시 이 메서드를 통과하게 된다.
//	@InitBinder
//	public void dateBinder(WebDataBinder binder) {
//		// 날짜 타입을 yyyy.MM.dd 형태로 받은 정책 추가
////		binder.registerCustomEditor(java.util.Date.class, "joinDate", //Date타입이 여러개일 때 표기
////				new CustomDateEditor(new SimpleDateFormat("yyyy.MM.dd"), false));
//		
//		// 비어있는 문자열이 들어오면 null로 치환해서 바인딩하는 정책 추가
//		binder.registerCustomEditor(String.class,
//				new StringTrimmerEditor(true));
//		
//	}
//	
//	
//	// InitBinder 정책 범위 설정
//	// - 범위 설정시 설정한 객체만 이 메서드를 거쳐간다.
//	// - 설정에 사용되는 이름: 해당 클래스 이름 소문자 (기본 인스턴스 이름) 혹은 따로 설정한 모델 속성명(attribute)
//	@InitBinder("user")
//	public void UserBinder(WebDataBinder binder) {
//		// User 객체를 사용하는 요청만 이곳의 정책을 따른다.
//		
//		// User 객체의 joinDate 필드에만 적용되는 정책
//		binder.registerCustomEditor(java.util.Date.class, "joinDate", // 필드명 (선택사항)
//				new CustomDateEditor(new SimpleDateFormat("yyyy.MM.dd"), false));
//	}
	
	
	
	
	
	
	
	
	
}
