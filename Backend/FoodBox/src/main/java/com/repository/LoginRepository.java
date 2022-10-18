package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Login;



public interface LoginRepository extends JpaRepository<Login, String>{
	

}
