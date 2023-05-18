package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	@GetMapping({ "/", "/login", "/logout" })
	public String index() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			Model model) {
		return "calender";
	}
}
