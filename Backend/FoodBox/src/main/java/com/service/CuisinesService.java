package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Cuisines;

import com.repository.CuisinesRepository;


@Service
public class CuisinesService {
	@Autowired
	CuisinesRepository cuisinerepo;
	
	public String storeCuisines(Cuisines cuisines)
	{
		
		cuisinerepo.save(cuisines);
		return "cuisines added successfully";
	}
	public String deleteCuisines(int id) {
		Optional<Cuisines> result  = cuisinerepo.findById(id);
		if(result.isPresent()) {
			Cuisines c = result.get();
			cuisinerepo.delete(c);
			return "Cuisine deleted successfully";
		}else {
			return "Cuisine not present";
		}
	}
	public List<Cuisines> findAllCuisines()
	{
		return cuisinerepo.findAll();
	}
	
	

}
