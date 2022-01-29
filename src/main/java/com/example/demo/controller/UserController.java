package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path =  "/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/home")
	public String welcome() {
		return "welcome to user application";
	}
	
	@PostMapping("/add")
	public @ResponseBody String addUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email, 
			@RequestParam String password ) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(firstName);
		userEntity.setLastName(firstName);
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		userRepository.save(userEntity);
		return "User has been successfully added to the system";
	}
	
	@GetMapping(path = "/all")
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
	
	
}
