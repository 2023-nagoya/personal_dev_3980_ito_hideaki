package com.example.demo.entity;

import java.sql.Date;

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
	private String userId;
	@Column(name = "now_date")
	private Date nowDate;
	private String title;
	private String content;

	public Integer getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}


	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Diaries(Date nowDate, String title, String content) {
		this.nowDate = nowDate;
		this.title = title;
		this.content = content;
	}

	public Date getNowDate() {
		// TODO 自動生成されたメソッド・スタブ
		return nowDate;
	}
	
	

}
