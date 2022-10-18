package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Food;
import com.bean.Login;
import com.repository.LoginRepository;
@Service

public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("admin")) {
							return "Admin sucessfully login";
				}else if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("user")){
							return "User successfully login";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "Email Id alreay exists";
		}else {
			if(login.getTypeOfUser().equals("admin")) {
				return "You can't create admin account";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}	
	}
	public String updatepwd(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login l=result.get();
			if(l.getPassword().equals(login.getPassword())){
		return "enter new password";
		
			
			}else
			{
				l.setPassword(login.getPassword());
				loginRepository.saveAndFlush(l);
				return "password updated successfully";
			}
			
		}
	else {
				return "Enter valid emailid";
			}
		}
	public String updateProfile(Login login) {
		Optional<Login> result  = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login l = result.get();
			l.setAddress(login.getAddress());
			l.setPhno(login.getPhno());
			l.setName(login.getName());
			loginRepository.saveAndFlush(l);
			return" user details updated successfully";
		}else {
			return "user not present";
		}
	

	}
}
