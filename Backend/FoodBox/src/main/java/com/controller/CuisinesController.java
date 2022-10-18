package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Cuisines;


import com.service.CuisinesService;

@RestController
@RequestMapping("cuisines")
@CrossOrigin
public class CuisinesController {
	@Autowired
	CuisinesService cuisineservice;
	
	
	@PostMapping(value = "storeCuisines",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Cuisines cuisines) {
		return cuisineservice.storeCuisines(cuisines);
	}

	@DeleteMapping(value="deleteCuisine/{id}")
	public String deleteCuisineUsingId(@PathVariable("id") int id) {
		return cuisineservice.deleteCuisines(id);
	}
	@GetMapping(value="findAllCuisines",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cuisines> findAllCuisines(){
		return cuisineservice.findAllCuisines();
		
	}
}
