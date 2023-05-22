package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface AccountRepository extends JpaRepository<Users, Integer> {
	List<Users> findByEmailAndPassword(String email,String password);
}
