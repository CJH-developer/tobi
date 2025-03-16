package com.example.tobi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tobi.vo.User;

public class NuserDAO extends UserDAO{

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		// 연결문자열 , DB_ID, DB_PW
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234" );
		return c;

	}
	
	// 사용자 추가
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)" );
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		// update 의 반환자는 int 형으로 0 또는 1이다.
		ps.executeUpdate();
		
		ps.close();
		
		c.close();
		
	}
	
	// 사용자 조회
	public User get(String id) throws ClassNotFoundException, SQLException{
		
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?" );
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}

	
}
