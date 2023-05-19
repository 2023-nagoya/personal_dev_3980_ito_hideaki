package com.example.demo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {

	@GetMapping("/calendar")
	public String main(
			@RequestParam(required = false) Integer id,
			Model model) {
		//実行時の日付/時刻情報を持つカレンダーインスタンス作成(ex 2021/01/08 22:00:00)
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		if(id != null) {
			cal.set(month, id+1);
		}
		//インタンスの持つ日付情報を1日に変更(ex 2021/01/01 22:00:00)
		cal.set(Calendar.DATE, 1);
		if(id != null) {
			cal.add(Calendar.MONTH, id);
		}
		
		
		//DAY_OF_WEEKでその日の曜日を返す2021/01/01は金曜なので6
		//（日曜:1,月:2,火:3,,,,土:7）
		//カレンダー的な最初のブランクの数は以下の式で表せる(1日が金なら空白は日、月、火、水、木の５個)
		int beforeBlank = cal.get(Calendar.DAY_OF_WEEK) - 1; //1
		//その月が何日まであるかは以下のメソッドで求められる(1月は31日)
		int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //31

		String calendar[][] = new String[6][7];
		int day = 1;
		for (int calendarRow_i = 0; calendarRow_i < 6; calendarRow_i++) {
			for (int calendarWeek_i = 0; calendarWeek_i < 7; calendarWeek_i++) {
				//beforebrankの繰り返し処理
				if (beforeBlank > 0) {
					calendar[calendarRow_i][calendarWeek_i] = "";
					beforeBlank--;

					//dayを作ってday=dayscountになるまで繰り返す
				} else if (daysCount != 0) {
					calendar[calendarRow_i][calendarWeek_i] = String.valueOf(day);
					day += 1;
					daysCount = daysCount - 1;
					System.out.println(calendar[calendarRow_i][calendarWeek_i]);
				}

			}
			
			model.addAttribute("previd",id != null ? id:null);
			model.addAttribute("nextid",id != null ? id:null);
			model.addAttribute("calendar", calendar);
			model.addAttribute("month",month);
		}
		return "calendar";
	}

}
