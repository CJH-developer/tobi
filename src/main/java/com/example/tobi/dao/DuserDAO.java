package com.example.tobi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DuserDAO extends UserDAO{

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// 연결문자열 , DB_ID, DB_PW
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234" );
		return c;
	}

	
}
