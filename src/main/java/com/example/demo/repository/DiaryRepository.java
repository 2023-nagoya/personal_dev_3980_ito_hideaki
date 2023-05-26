package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Diaries;


public interface DiaryRepository extends JpaRepository<Diaries, Integer> {

	List<Diaries> findByNowDateAndUserId(LocalDate date, Integer id);
//	List<Diaries> findAllById(Integer userId);
	List<Diaries> findByUserId(Integer userId);
	List<Diaries> findAllByUserId(Integer userId);
//	List<Diaries> findByFlgTrue(Boolean favoriteflg);
//	List<Diaries> findByDate(LocalDate key);
}
