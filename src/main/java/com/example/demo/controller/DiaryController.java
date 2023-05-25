package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diaries;
import com.example.demo.model.Account;
import com.example.demo.repository.DiaryRepository;

@Controller
public class DiaryController {

	@Autowired
	DiaryRepository diaryRepository;

	@Autowired
	Account account;

	@GetMapping("/diary/detail")
	public String index(
			@RequestParam("year") Integer year,
			@RequestParam("month") Integer month,
			@RequestParam("day") Integer day,
			Model model) {
		LocalDate date = LocalDate.of(year, month, day);
		List<Diaries> diaryList = diaryRepository.findByNowDateAndUserId(date, account.getUser().getId());
		boolean existsDiary = !diaryList.isEmpty();
		if (existsDiary) {
			model.addAttribute("diary", diaryList.get(0));
			return "detailDiary";
		} else {
			model.addAttribute("date", date);
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("day", day);

			return "newDiary";
		}
	}

	@GetMapping("diary/{id}/edit")
	public String edit(
			@PathVariable(value = "id") Integer id,
			Model model) {
		Diaries diary = diaryRepository.findById(id).get();
		model.addAttribute("diary", diary);
		return "editDiary";
	}

	@PostMapping("diary/{id}/edit")
	public String edit(
			@PathVariable(value = "id") Integer id,
			@RequestParam(value = "title", defaultValue = "") String title,
			@RequestParam(value = "content", defaultValue = "") String content,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			@RequestParam(value = "nowDate", defaultValue = "") LocalDate nowDate,
			@RequestParam(value = "weather", defaultValue = "") String weather,
			Model model) {
		Diaries editDiary = new Diaries(id, userId, nowDate, title, content, weather);
		diaryRepository.save(editDiary);
		return "redirect:/diary/detail?year=" + nowDate.getYear() + "&month=" + nowDate.getMonthValue() + "&day="
				+ nowDate.getDayOfMonth();
	}

	@PostMapping("/create/diary")
	public String create(
			@RequestParam(value = "title", defaultValue = "") String title,
			@RequestParam(value = "content", defaultValue = "") String content,
			@RequestParam("year") Integer year,
			@RequestParam("month") Integer month,
			@RequestParam("day") Integer day,
			@RequestParam("weather") String weather,
			@RequestParam(required = false, name="check") String check,
			Model model) {

		boolean favoriteFlg;
		if (check != null) {
			favoriteFlg = true;
		} else {
			favoriteFlg = false;
		}
		LocalDate date = LocalDate.of(year, month, day);
		Diaries diary = new Diaries(account.getUser().getId(), date, title, content, weather, favoriteFlg);
		diaryRepository.save(diary);

		return "redirect:/diary/detail?year=" + year + "&month=" + month + "&day=" + day;
	}

	@PostMapping("/diary/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id,
			Model model) {
		diaryRepository.deleteById(id);

		return "redirect:/calendar";
	}
}