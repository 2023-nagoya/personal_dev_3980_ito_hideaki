package com.example.demo.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diaries;
import com.example.demo.entity.Kigo;
import com.example.demo.entity.holiday;
import com.example.demo.model.Account;
import com.example.demo.repository.DiaryRepository;
import com.example.demo.repository.KigoRepository;
import com.example.demo.repository.holidayRepository;

@Controller
public class CalendarController {

	@Autowired
	DiaryRepository diaryRepository;

	@Autowired
	KigoRepository kigoRepository;
	
	@Autowired
	holidayRepository holidayRepository;

	@Autowired
	Account account;

	@GetMapping("/calendar")
	public String main(
			@RequestParam(required = false) Integer id,
			Model model) {

		//年、月、日の取得・設定
		Calendar cal = Calendar.getInstance();
		int beforeBlank = cal.get(Calendar.DAY_OF_WEEK) - 1; //1
		int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //31
		cal.set(Calendar.DATE, 1);

		if (id != null) {
			cal.add(Calendar.MONTH, id);
		}


		//カレンダー作成
		boolean bflg = true;
		String calendar[][] = new String[6][7];
		int day = 1;
		for (int calendarRow_i = 0; calendarRow_i < 6; calendarRow_i++) {
			for (int calendarWeek_i = 0; calendarWeek_i < 7; calendarWeek_i++) {
				if (beforeBlank > 0) {
					calendar[calendarRow_i][calendarWeek_i] = null;
					beforeBlank--;
				} else if (daysCount != 0) {
					calendar[calendarRow_i][calendarWeek_i] = String.valueOf(day);
					day++;

					daysCount = daysCount - 1;
					if (calendarRow_i == 5 && calendar[calendarRow_i][calendarWeek_i] != null) {
						bflg = false;
					}
				}

			}
			
			
			//カレンダーの空白を削除
			if (bflg) {
				String[][] checkDay = new String[5][7];
				for (int i = 0; i < 5; i++) {
					checkDay[i] = calendar[i];
				}
				model.addAttribute("calendar", checkDay);
			} else {
				model.addAttribute("calendar", calendar);
			}
			
			
			
			//マップを作成
			List<Diaries> value = diaryRepository.findByUserId(account.getUser().getId());
			Map<String, String> calendarMap = new HashMap<>();
			for (Diaries diary : value) {
				calendarMap.put(diary.getNowDate().toString(), diary.getTitle());
			}

			List<holiday> holidayValue = holidayRepository.findAll();
			Map<String, String> holidayMap = new HashMap<>(); 
			for(holiday holiday : holidayValue) {
				holidayMap.put(holiday.getNowDate(), holiday.getName());
			}

			int ten = 10;
			int month = cal.get(Calendar.MONTH) + 1;
			DecimalFormat decimalFormat = new DecimalFormat("00");
			String decimalMonth = decimalFormat.format(month);

			model.addAttribute("previd", id != null ? id : null);
			model.addAttribute("nextid", id != null ? id : null);
			model.addAttribute("month", cal.get(Calendar.MONTH) + 1);
			model.addAttribute("year", cal.get(Calendar.YEAR));
			model.addAttribute("cal", cal);
			model.addAttribute("ten", ten);
			model.addAttribute("decimalMonth", decimalMonth);
			model.addAttribute("calendarMap", calendarMap);
			model.addAttribute("holidayMap",holidayMap);
		}

		System.out.println();
		return "calendar";
	}

	@PostMapping("all/diary")
	public String allDiary(
			@RequestParam("year") Integer year,
			@RequestParam("month") Integer month,
			@RequestParam("day") Integer day,
			Model model) {
		Random rand = new Random();
		Integer id = rand.nextInt(20) + 1;
		Kigo kigo = kigoRepository.findAllById(id);

		Integer userId = account.getUser().getId();
		List<Diaries> diaries = diaryRepository.findAllByUserId(userId);

		model.addAttribute("day", day);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("kigo", kigo);
		model.addAttribute("diaries", diaries);

		return "allDiary";

	}

}