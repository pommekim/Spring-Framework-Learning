package com.kg.dbConfig;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	private Logger log = Logger.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() {
		
		// try(autoclose)를 사용
		try(Connection con = ds.getConnection()) {
			log.info(ds);
		} catch(SQLException e) {
			fail(e.getMessage());
		}
	}

//  다형성
//	Object = Integer
//	Object = String
//	Object = ArrayList
//	List = ArrayList
//	Set = HashSet
//	Set = TreeSet

}
