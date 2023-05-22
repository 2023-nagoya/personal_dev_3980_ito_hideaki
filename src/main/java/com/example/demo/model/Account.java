package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Users;

@Component
@SessionScope 
public class Account {
	
//	private String name;
//	
//	private String email;
//	
//	private String password;
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
	
}
