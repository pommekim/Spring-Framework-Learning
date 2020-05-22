package com.kg.beans;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//이 빈들을 루트 컨텍스트에 설정을 해두었기 때문에 루트 컨텍스트를 가져와야 함!
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BeansTest {
	
	private Reply newReply;
	
	private static Logger log = Logger.getLogger(BeansTest.class);
	
	@Autowired //객체를 알아서 생성을 해주는 어노테이션 (필요할 때)
	public void setNewReply(Reply newReply) {
		this.newReply = newReply;
	}
	
	@Test
	public void testExist() {
		// @AutoWired를 만났을 때, 스프링 ApplicationContext에 등록된 빈 객체라면
		// 인스턴스를 스프링이 대신 생성해준다.
		
		// 인스턴스를 스프링이 대신 생성해주는 행위를 '의존성 주입'이라고 부른다.
		// (DI: Dependency Injection)
		assertNotNull(newReply);
		
		log.info("newReply : " + newReply);
		log.info("newReply.user : " + newReply.getUser());
		
		
		
		
		
	}

}
