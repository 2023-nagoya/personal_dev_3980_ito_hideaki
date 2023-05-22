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
        
        int year = cal.get(Calendar.YEAR) ;
        int month = cal.get(Calendar.MONTH) + 1;
        
        if(id != null) {
            cal.set(month, id+1);
        }
        //インタンスの持つ日付情報を1日に変更(ex 2021/01/01 22:00:00)
        cal.set(Calendar.DATE, 1);
        
        if(id != null) {
            cal.add(Calendar.MONTH, id);
        }
        
        
        int beforeBlank = cal.get(Calendar.DAY_OF_WEEK) - 1; //1
        int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //31
        
        boolean bflg = true;
        
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
                    if(calendarRow_i == 5 && calendar[calendarRow_i][calendarWeek_i] != null) {
                        bflg = false;
                    }
                    System.out.println(calendar[calendarRow_i][calendarWeek_i]);
                }

            }
            if(bflg) {
                String [][] checkDay =new String[5][7];
                for(int i = 0;i < 5;i ++) {
                    checkDay[i] = calendar[i];
                }
                model.addAttribute("calendar",checkDay);
            }else {
                model.addAttribute("calendar", calendar);
            }
            model.addAttribute("previd",id != null ? id:null);
            model.addAttribute("nextid",id != null ? id:null);
            model.addAttribute("month",cal.get(Calendar.MONTH) + 1);
            model.addAttribute("year",cal.get(Calendar.YEAR));
            model.addAttribute("cal",cal);
        }
        return "calendar";
    }

}