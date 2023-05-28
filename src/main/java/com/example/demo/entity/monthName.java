package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monthName")
public class monthName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "now_month")
	private String nowMonth;

	private String name;

	public Integer getId() {
		return id;
	}

	public String getNowMonth() {
		return nowMonth;
	}

	public String getName() {
		return name;
	}

	public monthName() {
	}


}
