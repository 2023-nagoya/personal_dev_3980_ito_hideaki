package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@GetMapping({ "/", "/login", "/logout" })
	public String index() {
		return "login";
	}
	
	
}
