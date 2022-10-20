package com.controller;


import com.bean.Cuisines;
import com.service.CuisinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
