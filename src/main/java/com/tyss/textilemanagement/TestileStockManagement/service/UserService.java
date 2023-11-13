package com.tyss.textilemanagement.TestileStockManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.textilemanagement.TestileStockManagement.dao.UserDao;
import com.tyss.textilemanagement.TestileStockManagement.dto.User;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private ResponseStructure<User> structure;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser = dao.saveUser(user);
		structure.setData(user);
		structure.setMessage("saved");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User dbUser = dao.saveUser(user);
		structure.setData(user);
		structure.setMessage("updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> removeUser(int id) {
		boolean b = dao.removeUser(id);
		structure.setData(null);
		structure.setMessage("removed");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		structure.setData(user);
		structure.setMessage("updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		ResponseStructure<List<User>> structure=new ResponseStructure<>();;
		List<User> user = dao.getAllUser();
		structure.setData(user);
		structure.setMessage("updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}

}
