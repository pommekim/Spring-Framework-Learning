package com.kg.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/return/*")
public class ReturnController {
	
	private Logger log = Logger.getLogger(ReturnController.class);
	
	@GetMapping("/void")
	public void ex01() {
		log.info("/return/void로 요청이 들어왔습니다.");
	}

}
