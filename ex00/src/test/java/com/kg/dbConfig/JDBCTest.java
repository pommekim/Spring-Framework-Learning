package com.kg.dbConfig;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class JDBCTest {
	
	private Logger log = Logger.getLogger(JDBCTest.class);
	
	// 단 한번만 로딩되게 하는 방법
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// fail() : 테스트를 실패 처리한다.
			fail("드라이버를 못찾았습니다.");
		}
	}
	
	@Test
	public void testConnection() {
		// 어떤 DB를 사용하더라도, jdbc만 있다면 똑같은 절차를 반복하게 된다.
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "TIGER";
		String sql = "SELECT * FROM EMP";
		
		// try with AutoClose
		// - try문의 () 내부에 AutoClose 인터페이스가 구현된 객체를 넣을 수 있다.
		// - jdk 1.7 이후에 사용 가능
		// - finally문에서 close해줄 필요가 없어짐.
		
		try (Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			log.info(con);
			
			// ResultSetMetaData : 테이블 정보가 들어있다. (컬럼명, 컬럼개수.. 등 필요한 것들)
			ResultSetMetaData meta = rs.getMetaData();
			
			log.info("---------------------------------------------------------");
			while(rs.next()) {
				// String row = ""; // 매우 느리다.
				// row += rs.getObject(i) + " / "; // 매우 느리다.
				
				// 문자열을 만드는 클래스, 문자열에 += 하는 것보다 훨씬 빠르다.
				StringBuilder row = new StringBuilder();
				for(int i=1; i<meta.getColumnCount(); i++) {
					row.append(rs.getObject(i) + " / ");
				}
				log.info(row);
			}
			
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
	}

}
