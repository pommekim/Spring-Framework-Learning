package com.kg.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kg.beans.User;

@Controller
@RequestMapping("/return/*")
public class ReturnController {
	
	// 1. RequestMapping으로 설정하는 경로
	//	- 사용자가 웹 브라우저를 통해 이곳의 알맞은 컨트롤러를 찾는에 사용하는 경로
	//	- ex) http://www.naver.com/webtoon
	
	// 2. return할 때 ModelAndView 혹은 문자열로 설정하는 경로
	//	- 컨트롤러가 사용자에게 보여줄 View 페이지의 경로 (웹서버 내부 경로)
	//	- servlet-context.xml의 prefix/suffix가 붙어서 경로를 완성한다.
	
	private Logger log = Logger.getLogger(ReturnController.class);
	
	@GetMapping("/void")
	public void ex01() {
		log.info("/return/void로 요청이 들어왔습니다.");
	}
	
	@GetMapping("/mav")
	public ModelAndView ex02() {
		// ModelAndView : 모델처럼 데이터를 실을 수도 있고,
		// String처럼 다음 view 페이지의 경로도 가지고 있는 타입
		// 생성자의 매개변수에 주소값을 써도 되고, set메서드를 통해 주소값을 넣어줘도 됨! (선택)
		ModelAndView view = new ModelAndView();
		
		// ViewName을 설정 : String 타입 리턴과 같음
		view.setViewName("/return/mav"); // /view/return/mav.jsp
		view.addObject("name", "홍길동"); // ${name}
		// org.springframework.http.HttpStatus : HTTP 상태 코드 상수들이 선언되어 있다.
		view.setStatus(HttpStatus.NOT_FOUND);
		
		return view;
	}
	
	@GetMapping("/entity")
	public ResponseEntity<String> ex03() {
		// HttpResponse를 처음부터 끝까지 다 직접 만들어서 응답한다.
		String body = "<html><body><h2>직접 만든 Body</h2></body></html>";
		
		HttpHeaders header = new HttpHeaders();
		
		header.add("Content-type", "text/html; charset=UTF-8");
	
		return new ResponseEntity<>(body, header, HttpStatus.OK);
	}
	
	@GetMapping("/bean")
	@ResponseBody
	public User ex04() {
		// @ResponseBody
		// - JSP로 생성된 View 페이지를 응답하는 것이 아니라
		//   이 메서드의 리턴값을 바로 응답한다.
		User u = new User();
		u.setAge(33);
		u.setJoinDate(new Date());
		u.setName("홍길동");
		
		// jackson-databind 라이브러리
		// - 자자빈 객체를 자동으로 JSON 타입으로 변환해주는 라이브러리
		return u;
	}
	
	
	
	
	
	
	
	
	

}







