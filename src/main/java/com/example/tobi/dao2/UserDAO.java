package com.example.tobi.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tobi.vo.User;

public class UserDAO {

	private SimpleConnectionMaker simpleConnectionMaker;
	private ConnectionMaker connectionMaker;
	
	/*
	 * public UserDAO() { simpleConnectionMaker = new SimpleConnectionMaker(); }
	 */
	
	/*
	 * public UserDAO() { connectionMaker = new DConnectionMaker(); }
	 */
	
	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)" );
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		// update 의 반환자는 int 형으로 0 또는 1이다.
		ps.executeUpdate();
		
		ps.close();
		
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		
		Connection c = connectionMaker.makeConnection();
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
