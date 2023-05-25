package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diaries")
public class Diaries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "now_date")
	private LocalDate nowDate;
	private String title;
	private String content;
	private String weather;
	@Column(name ="favorite_flg")
	private boolean favoriteFlg;
	
	public boolean isFavoriteFlg() {
		return favoriteFlg;
	}

	public boolean geta() {
		return favoriteFlg;
	}

	public Integer getId() {
		return id;
	}

	public String getWeather() {
		return weather;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Diaries() {

	}

	public Diaries(Integer userId,LocalDate nowDate, String title, String content,String weather,boolean favoriteFlg) {
		this.nowDate = nowDate;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.weather = weather;
		this.favoriteFlg = favoriteFlg;
	}


	public Diaries(Integer id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Diaries(Integer id, Integer userId, LocalDate nowDate, String title, String content,String weather) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		this.userId = userId;
		this.nowDate = nowDate;
		this.title = title;
		this.content = content;
		this.weather = weather;
	}

	public LocalDate getNowDate() {
		// TODO 自動生成されたメソッド・スタブ
		return nowDate;
	}
	

}
