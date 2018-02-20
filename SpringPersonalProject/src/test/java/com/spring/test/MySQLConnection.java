package com.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class MySQLConnection {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/kim_schema01";
	private static final String USER = "kimhongsik";
	private static final String PWD = "kimhongsik";
	
	@Test
	public void testConn() throws Exception{
		Class.forName(DRIVER);
		try(Connection conn = DriverManager.getConnection(URL, USER, PWD)){
			System.out.println(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
