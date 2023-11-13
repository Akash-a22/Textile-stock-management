package com.tyss.textilemanagement.TestileStockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.textilemanagement.TestileStockManagement.dto.User;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);		
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);		
	}
	
	@DeleteMapping("/removeUser")
	public ResponseEntity<ResponseStructure<User>> removeUser(@RequestParam int id) {
		return service.removeUser(id);		
	}
	
	@GetMapping("/getUserById")
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return service.getUserById(id);		
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		return service.getAllUser();		
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> userLogin(String email,String password) {
		return service.userLogin(email,password);		
	}
	

}
