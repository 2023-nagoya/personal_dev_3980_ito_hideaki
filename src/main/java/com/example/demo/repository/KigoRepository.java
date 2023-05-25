package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Kigo;

public interface KigoRepository extends JpaRepository<Kigo, Integer>{
	Kigo findAllById(Integer id);
}
