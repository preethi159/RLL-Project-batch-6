package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Cuisines;

@Repository
public interface CuisinesRepository extends JpaRepository<Cuisines, Integer>{

}
