package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String index() {
		//セッションをリセットする
		session.invalidate();
		return "login";
	}

	//ログイン処理をする
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model,
			RedirectAttributes redirectAttributes) {

		//emailとpasswordに一致するデータを取得する
		List<Users> userList = accountRepository.findByEmailAndPassword(email, password);

		//データベースに存在するかどうか判定
		if (!userList.isEmpty()) {
			Users user = userList.get(0);
			account.setUser(user);
			return "redirect:/calendar";
		} else {
			redirectAttributes.addFlashAttribute("error", "メールアドレスとパスワードが一致しませんでした。");
			return "redirect:/login";
		}
	}

	//新規アカウントの作成画面への遷移
	@GetMapping("/create/account")
	public String createAccount() {
		return "createAccount";
	}

	//アカウントを追加する
	@PostMapping("/create/account")
	public String addAccount(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "confirm-password", defaultValue = "") String confirmPassword,
			Model model) {
		List<String> errorMessageList = new ArrayList<>();
		if (name.length() == 0) {
			errorMessageList.add("名前を入力してください");
		}
		if (email.length() == 0) {
			errorMessageList.add("メールアドレスを入力してください");
		}
		if (password.length() == 0) {
			errorMessageList.add("パスワード入力してください");
		}
		if (password.length() < 8) {
			errorMessageList.add("パスワードは8文字以上で入力してください");
		}
		if (!password.equals(confirmPassword)) {
			errorMessageList.add("パスワードが一致しません");
		}
		if (errorMessageList.size() > 0) {
			model.addAttribute("errorMessageList", errorMessageList);
			return "createAccount";
		}
		//新規アカウントを保存
		Users user = new Users(name, password, email);
		accountRepository.save(user);
		return "redirect:/login";
	}

	//パスワード再設定画面を表示
	@GetMapping("/passwordReset")
	public String resetPassword() {
		return "passwordReset";
	}

	//パスワードの再設定画面への遷移
	@PostMapping("/passwordReset")
	public String changePassword(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			Model model, RedirectAttributes redirectAttributes) {

		List<Users> user = accountRepository.findByNameAndEmail(name, email);
		if (user.isEmpty()) {
			redirectAttributes.addFlashAttribute("errorMessage", "アカウントが存在しないか、ユーザ名とメールアドレスが一致しませんでした");
			return "redirect:/passwordReset";
		} else {
			Users users = user.get(0);
			model.addAttribute("user", users);
			return "newPassword";
		}

	}

	//パスワードをデータベースの更新
	@PostMapping("/setPassword")
	public String setPassword(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "confirmpassword", defaultValue = "") String confirmpassword,
			RedirectAttributes redirectAttributes, Model model) {

		List<Users> user = accountRepository.findByNameAndEmail(name, email);
		Users users = user.get(0); 
		//エラー文を追加する
		List<String> errorMessages = new ArrayList<>();
		if (password.length() == 0) {
			errorMessages.add("パスワードを入力してください");
		}
		if (password.length() < 8) {
			errorMessages.add("パスワードは8文字以上で入力してください");
		}
		if (!password.equals(confirmpassword)) {
			errorMessages.add("パスワードが一致しません");
		}
		if (errorMessages.size() > 0) {
			//エラーメッセージは新しいパスワードを入力する画面で表示する
			model.addAttribute("errorMessages", errorMessages);
			model.addAttribute("user",users);
			return "newPassword";
		}

		//パスワード更新
		Users user2 = new Users(id, name, password, email);
		accountRepository.save(user2);

		redirectAttributes.addAttribute("passwordChanged", true);
		return "redirect:/login";
	}

}