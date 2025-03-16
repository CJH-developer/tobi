package com.example.tobi.dao;

import java.sql.Connection;
import java.sql.SQLException;



public abstract class UserDAO {
	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
}
