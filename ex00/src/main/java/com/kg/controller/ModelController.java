package com.kg.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kg.beans.User;

@Controller
@RequestMapping("/model/*")
public class ModelController {
	
	private Logger log = Logger.getLogger(ModelController.class);
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("time", new java.util.Date());
		
		return "/model/index";
		// servlet-context.xml에 설정된 ViewResolver에 의해
		// 리턴하는 주소값에 prefix와 suffix가 더해진다.
		// -> /WEB-INF/view/model/index.jsp
	}
	
	
	// @GetMapping, @PostMapping
	// - Get/Post만 받는 @RequestMapping을 축약시켜놓은 어노테이션
	@GetMapping("/info")
	public String userInfo(User user) {
		// 아무것도 안해도 이미 모델에 실려있다.
		log.info("--- user ---");
		log.info(user.toString());
		
		return "/model/info";
	}
	
	
	// http://localhost:8080/controller/model/info2?name=aa&age=11&joinDate=2020-05-27&page=3
	@GetMapping("/info2")
	public String userInfo2(User user, int page, Model model) {
		log.info("page: " + page);
		
		model.addAttribute("page", page);
		
		return "/model/info2";
	}
	
	
//	// http://localhost:8080/controller/model/info3?name=aa&age=11&joinDate=2020-05-27&page=3
//	@GetMapping("/info3")
//	public String userInfo3(User user, @ModelAttribute("page") int page) {
//		log.info("info3 page: " + page);
//		
//		return "/model/info2";
//	}
	
	
	// http://localhost:8080/controller/model/info3?name=aa&age=11&joinDate=2020-05-27&page=3
	@GetMapping("/info3")
	public String userInfo3(User user,
			@RequestParam("page") ArrayList<Integer> page, Model model,
			@ModelAttribute("cities") ArrayList<String> cities) {
		
		// @RequestParam으로 page를 여러개 받아서 @Model에 값을 실어 보낸다.
		log.info("info3 page: " + page);
		model.addAttribute("pages", page);
		
		// @ModelAttribute는 데이터를 실어 보내기 위해 존재한다.
		// (하나까지는 자동으로 받아준다.)
		cities.add("london");
		cities.add("paris");
		cities.add("seoul");
		log.info("cities: " + cities);
			
		return "/model/info2";
	}
	
	
	// /model/reget?name=abc&age=111&joinDate=2020-05-27
	@GetMapping("/reget")
	public String redirectGet(User user) {
		// 리다이렉트를 이용하면 새로고침과 뒤로가기가 무효화된다.
		// 뒤로가기 & 새로고침으로 /model/reget으로 다시 요청을 걸기 힘들어진다.
		return "redirect:/model/info?"
				+ "name=" + user.getName()
				+ "&age=" + user.getAge()
				+ "&joinDate=2020-05-27";
		// Get방식이기 때문에 Date() 객체를 보내기가 약간 귀찮다.
	}
	
	
	// /model/repost?name=cba&age=222&joinDate=2020-05-30
	// 데이터가 주소에 딸려서 가는 것이 아니라 숨어서 갈 수 있음! (세션 활용)
	@GetMapping("/repost")
	public String redirectPost(User user, RedirectAttributes rttr) {
		// 리다이렉트를 이용할 때 1회성으로 데이터를 전달하는 용도로 사용된다.
		// 내부적으론 세션을 이용해 구현되어 있다.
		
		// 리다이렉트시에도 자바빈 규칙을 따르는 객체는 알아서 전달해준다.
		rttr.addFlashAttribute("user", user);
		
		return "redirect:/model/info";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
