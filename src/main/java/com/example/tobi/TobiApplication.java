package com.example.tobi;


import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tobi.dao.NuserDAO;
import com.example.tobi.vo.User;

@SpringBootApplication
public class TobiApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		NuserDAO dao = new NuserDAO();
		
		User user = new User();
		user.setId("user002");
		user.setName("user002");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공!!");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName() + "조회 성공");
		
		
		
//		SpringApplication.run(TobiApplication.class, args);
	}

}
