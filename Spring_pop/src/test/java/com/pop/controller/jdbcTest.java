package com.pop.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class jdbcTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/pop?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
