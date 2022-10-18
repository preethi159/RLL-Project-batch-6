package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Food;

import com.service.FoodService;

@RestController
@RequestMapping("food")
@CrossOrigin
public class FoodController {
	@Autowired
	FoodService foodservice;
	
	@GetMapping(value="/")
	public String Hello()
	{
		return "hi";
	}
	
	// http://localhost:9090/food/storeFood
	
	@PostMapping(value = "storeFood",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Food food) {
		return foodservice.storeFood(food);
	}
	
	// http://localhost:9090/food/findAllFood
	@GetMapping(value="findAllFood",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Food> getAllFood() {
		return foodservice.getAllFood();
	}
	// http://localhost:9090/food/updateFood
	
	@PatchMapping(value = "updateFood",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateFood(@RequestBody Food food) {
		return foodservice.updateFood(food);
	}
	
	
	// http://localhost:9090/food/deleteFood/
	@DeleteMapping(value="deleteFood/{id}")
	public String deleteFoodUsingId(@PathVariable("id") int id) {
		return foodservice.deleteFood(id);
	}
	
	
	// http://localhost:9090/food/deleteFoodByCuisine/
	@DeleteMapping(value="deleteFoodByCuisine/{fid}")
	public String deleteFoodUsingCuisine(@PathVariable("fid") int fid) {
		return foodservice.deleteFoodByCuisine(fid);
	}
	
	
	@GetMapping(value="findFoodByCuisine/{fid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Food> findFoodByCuisine(@PathVariable("fid") Integer fid) {
		return foodservice.findFoodByCuisine(fid);
	}
	
	
	@GetMapping(value="findFoodByName/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Food> findFoodByName(@PathVariable("name") String name) {
		return foodservice.findFoodName(name);
	}
	
	
}
