package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Food;
import com.bean.Login;
import com.service.LoginService;
@RestController
@RequestMapping("login")
@CrossOrigin

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		System.out.println("I cam here");
		return loginService.signIn(login);
		
	}
	
	@PostMapping(value = "signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		System.out.println(login);
		return loginService.signUp(login);
	}
	@PatchMapping(value = "updatepwd",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updatepwd(@RequestBody Login login) {
		return loginService.updatepwd(login);
	}
	@PatchMapping(value = "updateprofile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateprofile(@RequestBody Login login) {
		return loginService.updateProfile(login);
	}


}
