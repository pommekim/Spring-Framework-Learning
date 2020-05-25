package com.kg.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
