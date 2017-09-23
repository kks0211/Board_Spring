package com.kwan.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConectorTest {
	
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book";
	private static final String USER = "kwan";
	private static final String PW = "kwan";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(Driver);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("con =====> " + con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
