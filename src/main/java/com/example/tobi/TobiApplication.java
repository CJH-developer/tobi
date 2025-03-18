package com.example.tobi;


import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tobi.dao.NuserDAO;
import com.example.tobi.dao2.ConnectionMaker;
import com.example.tobi.dao2.DConnectionMaker;
import com.example.tobi.dao2.UserDAO;
import com.example.tobi.vo.User;

@SpringBootApplication
public class TobiApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDAO dao = new UserDAO(connectionMaker);
		
		User user = new User();
		user.setId("user005");
		user.setName("user005");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공!!");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName() + "조회 성공");
		
		
		
//		SpringApplication.run(TobiApplication.class, args);
	}

}
