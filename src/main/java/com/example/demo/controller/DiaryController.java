package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diaries;
import com.example.demo.repository.DiaryRepository;

@Controller
public class DiaryController {

	@Autowired
	DiaryRepository diaryRepository;

	@GetMapping("/diary/add")
	public String index(
			@RequestParam("year") String year,
			@RequestParam("month") String month,
			@RequestParam("day") String day,
			Model model) {

		int yearInteger = Integer.valueOf(year);
		int monthInteger = Integer.valueOf(month);
		int dayInteger = Integer.valueOf(day);
		LocalDate date = LocalDate.of(yearInteger, monthInteger, dayInteger);

		List<Diaries> diaryList = diaryRepository.findByNowDate(date);
		//投稿があれば、詳細ページ表示
		for (Diaries diary : diaryList) {
			if (diary.getNowDate().equals(date)) {
				return "editDiary";
			}
		}
		return "newDiary";
	}
	

}

//	@PostMapping("/diary/detail")
//	public String add(
//			@RequestParam(value = "title", defaultValue = "") String title,
//			@RequestParam(value = "now_date", defaultValue = "") Date now_date,
//			@RequestParam(value = "content", defaultValue = "") String content,
//			Model model) {
//		Diaries diary = new Diaries(now_date, title, content);
//		
//		diaryRepository.save(diary);
//		
//		return "diaryAdd";
//	}
