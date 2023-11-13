package com.tyss.textilemanagement.TestileStockManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.textilemanagement.TestileStockManagement.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService service;
	
//	@PostMapping("/saveUser")
//	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
//		return service.saveUser(user);		
//	}

}
