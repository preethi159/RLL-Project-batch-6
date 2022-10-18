package com.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Food;


@Repository

public interface FoodRepository  extends JpaRepository<Food, Integer> {
	@Query("select p from Food p where p.fid =:fid")
	public List<Food> findFoodByCusine(@Param("fid") Integer fid);

	
	@Query("select f from Food f where f.name =:name")
	public List<Food> findFoodByName(@Param("name") String name);
}
