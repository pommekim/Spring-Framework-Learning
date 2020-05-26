package com.kg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/model/*")
public class ModelController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("time", new java.util.Date());
		
		return "/model/index";
		// servlet-context.xml에 설정된 ViewResolver에 의해
		// 리턴하는 주소값에 prefix와 suffix가 더해진다.
		// -> /WEB-INF/view/model/index.jsp
	}

}
