package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;
	
	@Autowired
	Account account;

	@Autowired
	AccountRepository accountRepository;
	
	//ログイン画面の表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		//セッションをリセットする
		session.invalidate();
		//エラー処理を追加する。
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}
		return "login";
	}
	
	//ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			Model model) {
		//emailとpasswordに一致するデータを取得する
		Users user = accountRepository.findByEmailAndPassword(email, password).get(0);
		account.setUser(user);
		
		return "redirect:/calendar";
	}

	//新規アカウントの作成画面への遷移
	@GetMapping("/create/account")
	public String create() {
		return "createAccount";
	}
	
	//データベースに値を保存する
	@PostMapping("/create/account")
	public String add(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		//新規アカウントを作成
		Users user = new Users(name, password, email);
		accountRepository.save(user);
		return "redirect:/login";
	}
	
	//パスワードの再設定画面への遷移
	@GetMapping("/passwordReset")
	public String reset() {
		return "passwordReset";
	}
}