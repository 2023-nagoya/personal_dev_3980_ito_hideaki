package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "holiday")
public class holiday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	@Column(name="now_date")
	private String nowDate;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getNowDate() {
		return nowDate;
	}
	public holiday() {
		
	}
	
	
	
	
}
