package com.example.demo.entity;

import java.sql.Date;

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

	private String user_id;
	private Date now_date;
	private String title;
	private String content;

	public Integer getId() {
		return id;
	}

	public String getUser_id() {
		return user_id;
	}

	public Date getNow_date() {
		return now_date;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}
