package com.kg.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kg.beans.User;
import com.kg.util.Animal;

// @Controller : 이 클래스가 컨트롤러임을 스프링에게 알린다. (이 클래스를 스프링이 관리한다.)
// @RequestMapping : 이 컨트롤러에 찾아올 수 있는 URL을 맵핑한다.

@Controller
@RequestMapping("/test/*")
public class TestController {
	
	private static Logger log = Logger.getLogger(TestController.class);
	
	// 이곳에 접속할 수 있는 url : /test/
	@RequestMapping("")
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
	
	@RequestMapping(value="/param2", method=RequestMethod.GET)
	public void paramTest2(
			@RequestParam("name") String name,
			@RequestParam("age") int age
			) {
		// @RequestParam을 이용해 함수의 매개변수로 파라미터 받아오기
		log.info("name : " + name);
		log.info("age : " + age);
		
	}
		
		
		
		
		
		
		
	
	
}
