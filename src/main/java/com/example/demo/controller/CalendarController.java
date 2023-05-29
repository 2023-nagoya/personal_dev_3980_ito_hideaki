package com.example.demo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diaries;
import com.example.demo.entity.Kigo;
import com.example.demo.entity.holiday;
import com.example.demo.entity.monthName;
import com.example.demo.model.Account;
import com.example.demo.repository.DiaryRepository;
import com.example.demo.repository.KigoRepository;
import com.example.demo.repository.holidayRepository;
import com.example.demo.repository.monthNameRepository;

@Controller
public class CalendarController {

	@Autowired
	DiaryRepository diaryRepository;

	@Autowired
	KigoRepository kigoRepository;

	@Autowired
	holidayRepository holidayRepository;
	
	@Autowired
	monthNameRepository monthNameRepository;

	@Autowired
	Account account;

	@GetMapping("/calendar")
	public String main(
			@RequestParam(required = false) Integer id,
			Model model) {

		//カレンダーオブジェクトを生成し、現在の日付を設定
		Calendar cal = Calendar.getInstance();
		
		
		int month = cal.get(Calendar.MONTH) + 1;

		if (id != null) {
			cal.set(month, id + 1);
		}
		
		//idがnullでない場合、idの値を月としてカレンダーオブジェクトに追加
		if (id != null) {
			cal.add(Calendar.MONTH, id);
		}

		//カレンダーオブジェクトの日付を1日に設定する
		cal.set(Calendar.DATE, 1);

		//週の始まりの曜日を取得し、１を引いた値の分空白が存在する
		int beforeBlank = cal.get(Calendar.DAY_OF_WEEK) - 1;

		//現在の月の最大日数を取得し、daysCountに格納する
		int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		

		//カレンダー作成
		boolean bflg = true;

		//カレンダーの最大6行7列の2次元配列を作成
		String calendar[][] = new String[6][7];
		int day = 1;
		for (int calendarRow_i = 0; calendarRow_i < 6; calendarRow_i++) {
			for (int calendarWeek_i = 0; calendarWeek_i < 7; calendarWeek_i++) {
				//beforeBlankが0より大きい場合、nullをセルに設定する
				if (beforeBlank > 0) {
					calendar[calendarRow_i][calendarWeek_i] = null;
					beforeBlank--;
					//daysCountが0でない限り、日付をcalendar配列に追加する
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
				//5行7列のcheckDay２次元配列を作成
				String[][] checkDay = new String[5][7];
				for (int i = 0; i < 5; i++) {
					//カレンダーの行が5行の場合、checkDayにcalendarを格納
					checkDay[i] = calendar[i];
				}
				model.addAttribute("calendar", checkDay);
				//カレンダーの行が5でない場合、元のカレンダーを追加する
			} else {
				model.addAttribute("calendar", calendar);
			}

			//日記のタイトルを表示
			List<Diaries> value = diaryRepository.findByUserId(account.getUser().getId());
			Map<String, String> calendarMap = new HashMap<>();
			for (Diaries diary : value) {
				calendarMap.put(diary.getNowDate().toString(), diary.getTitle());
			}
			//祝日を表示
			List<holiday> holidayValue = holidayRepository.findAll();
			Map<String, String> holidayMap = new HashMap<>();
			for (holiday holiday : holidayValue) {
				holidayMap.put(holiday.getNowDate(), holiday.getName());
			}
			
			//旧暦月を表示
			List<monthName> monthValue = monthNameRepository.findAll();
			Map<String, String> monthMap =new HashMap<>();
			for (monthName hoge : monthValue) {
				monthMap.put(hoge.getNowMonth(), hoge.getName());
			}
			
			int ten = 10;
			int month2 = cal.get(Calendar.MONTH) + 1;
			DecimalFormat decimalFormat = new DecimalFormat("00");
			String decimalMonth = decimalFormat.format(month2);
			model.addAttribute("decimalMonth", decimalMonth);

			
			model.addAttribute("previd", id != null ? id : null);
			model.addAttribute("nextid", id != null ? id : null);
			model.addAttribute("month", cal.get(Calendar.MONTH) + 1);
			model.addAttribute("year", cal.get(Calendar.YEAR));
			model.addAttribute("cal", cal);
			model.addAttribute("ten", ten);

			model.addAttribute("calendarMap", calendarMap);
			model.addAttribute("holidayMap", holidayMap);
			model.addAttribute("monthMap",monthMap);
		}

		System.out.println();
		return "calendar";
	}

	@GetMapping("all/diary")
	public String allDiary(
			@RequestParam(name = "year",defaultValue="") Integer year,
			@RequestParam(name = "month" ,defaultValue="") Integer month,
			@RequestParam(name = "day" ,defaultValue="") Integer day,
			@RequestParam(required = false, name = "favorite") String favorite,
			Model model) {
		Random rand = new Random();
		Integer id = rand.nextInt(20) + 1;
		Kigo kigo = kigoRepository.findAllById(id);
		
		Integer userId = account.getUser().getId();
		List<Diaries> diaries = diaryRepository.findByUserId(userId);
		
		List<Diaries> favoriteList = new ArrayList<>();
    	for (Diaries favoritediary : diaries) {
            if (favoritediary.getFavoriteFlg()) {
	                favoriteList.add(favoritediary);
	            }
	        }
		System.out.println("@@@@@@@@000");
		System.out.println(diaries.get(0).getFavoriteFlg());
		System.err.println("@@@@@@@@@@@");
    	model.addAttribute("favoriteList",favoriteList);
		model.addAttribute("day", day);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("kigo", kigo);
		model.addAttribute("diaries", diaries);

		return "allDiary";

	}

}