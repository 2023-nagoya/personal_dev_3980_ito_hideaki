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
    public String index(
            @RequestParam(name = "error", defaultValue = "") String error,
            Model model) {
        //セッションをリセットする
        session.invalidate();
        //エラー処理を追加する。
        if (error.equals("notLoggedIn")) {
            model.addAttribute("errorMessage", "ログインしてください");
        }
        return "login";
    }

    //ログイン処理
    @PostMapping("/login")
    public String login(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            Model model, RedirectAttributes redirectAttributes) {
        //emailとpasswordに一致するデータを取得する
        List<Users> userList = accountRepository.findByEmailAndPassword(email, password);
        if(!userList.isEmpty()) {
            Users user = userList.get(0);
            account.setUser(user);
            return "redirect:/calendar";
        }else {
            redirectAttributes.addFlashAttribute("error","メールアドレスとパスワードが一致しませんでした。");
            return "redirect:/login";
        }

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
            @RequestParam(value = "confirm-password", defaultValue = "")String confirmPassword,
            Model model) {
            List<String> errorMessageList = new ArrayList<>();
            if(name.length() == 0) {
                errorMessageList.add("名前を入力してください");
            }
            if(email.length()==0) {
                errorMessageList.add("メールアドレスを入力してください");
            }
            if(password.length() == 0) {
                errorMessageList.add("パスワード入力してください");
            }
            if(password.length() < 8) {
                errorMessageList.add("パスワードは8文字以上で入力してください");
            }
            if(!password.equals(confirmPassword)) {
                errorMessageList.add("パスワードが一致しません");
            }
            if(errorMessageList.size() > 0) {
                model.addAttribute("errorMessageList",errorMessageList);
                return "createAccount";
            }
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