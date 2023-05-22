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
	private Integer userId;
	@Column(name = "now_date")
	private Date nowDate;
	private String title;
	private String content;

	public Integer getId() {
		return id;
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

	public Diaries(Date nowDate, String title, String content) {
		this.nowDate = nowDate;
		this.title = title;
		this.content = content;
	}

	public Diaries(Integer id, Date nowDate, String title, String content) {
		this.id = id;
		this.nowDate = nowDate;
		this.title = title;
		this.content = content;
	}

	public Diaries(Integer id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Diaries(Integer id, Integer userId, String title, String content) {
		this.id = id;
		this.userId=userId;
		this.title = title;
		this.content = content;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Diaries(Integer id, Integer userId, Date nowDate, String title, String content) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		this.userId=userId;
		this.nowDate= nowDate;
		this.title = title;
		this.content = content;
	}

	public Date getNowDate() {
		// TODO 自動生成されたメソッド・スタブ
		return nowDate;
	}

}
