package com.kg.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//getLogger메서드를 통해 로거를 끌어다 쓰고 있음.
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//직접 생성한 log4j 객체
	private static final Logger log4j = org.apache.log4j.Logger.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		//서비스 준비(개발 단계) ----------------------------> 서비스 시작
		//ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
		
		log4j.setLevel(Level.ALL);
		
		log4j.trace("가장 자세한 내용을 담아야 하는 TRACE 로그");
		log4j.debug("디버깅에 필요한 내용을 담는 DEBUG 로그");
		log4j.info("일반적인 내용을 담는 INFO 로그");
		log4j.warn("문제가 생길수도 있는 WARN 로그");
		log4j.error("에러가 발생했을 때를 기록하는 ERROR 로그");
		log4j.fatal("가장 치명적인 에러를 기록하는 FATAL 로그");
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
