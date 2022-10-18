package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Food;

import com.repository.FoodRepository;

@Service
public class FoodService {
@Autowired
FoodRepository foodrepo;


public String storeFood(Food food)
{
	foodrepo.save(food);
	return "food added successfully";
}
public List<Food> getAllFood()
{
	return foodrepo.findAll();
}

public List<Food> findFoodByCuisine(Integer fid)
{
	return foodrepo.findFoodByCusine(fid);
}

public List<Food> findFoodName(String name)
{
	return foodrepo.findFoodByName(name);
}


public String updateFood(Food food) {
	Optional<Food> result  = foodrepo.findById(food.getId());
	if(result.isPresent()) {
		Food f = result.get();
		f.setPrice(food.getPrice());
		f.setOffer(food.getOffer());
		f.setUrl(food.getUrl());
		f.setDescription(food.getDescription());
		foodrepo.saveAndFlush(f);
		return "Food details updated successfully";
	}else {
		return "Food not present";
	}
}
public String deleteFood(int id) {
	Optional<Food> result  = foodrepo.findById(id);
	if(result.isPresent()) {
		Food f = result.get();
		foodrepo.delete(f);
		return "Food deleted successfully";
	}else {
		return "Food not present";
	}
}
	public String deleteFoodByCuisine(int fid) {
		Optional<Food> result  = foodrepo.findById(fid);
		if(result.isPresent()) {
			Food f = result.get();
			foodrepo.delete(f);
			return "Food deleted successfully";
		}else {
			return "Food not present";
		}
}
}

