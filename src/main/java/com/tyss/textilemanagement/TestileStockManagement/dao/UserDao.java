package com.tyss.textilemanagement.TestileStockManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.User;
import com.tyss.textilemanagement.TestileStockManagement.exception.OneUserWithGivenRoleIsAlreadyPresentException;
import com.tyss.textilemanagement.TestileStockManagement.exception.UserNotFoundException;
import com.tyss.textilemanagement.TestileStockManagement.exception.UserWithGivenEmailIsAlreadyExist;
import com.tyss.textilemanagement.TestileStockManagement.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		User dbUser = repository.findByEmail(user.getEmail());
		if (dbUser == null) {
			if (user.getRole().equals("shopkepper") || user.getRole().equals("manager")) {
				repository.save(user);
				return user;
			} else if (user.getRole().equals("admin") || user.getRole().equals("wholeseller")) {
				List<User> list = repository.findAll();
				if (list != null && !list.isEmpty()) {
					for (User u : list) {
						if (u.getRole().equals(user.getRole())) {
							throw new OneUserWithGivenRoleIsAlreadyPresentException();
						}
					}
				}
				repository.save(user);
				return user;
			}

			repository.save(user);
			return user;
		}
		throw new UserWithGivenEmailIsAlreadyExist();
	}

	public User updateUser(User user) {
		Optional<User> dbUser = repository.findById(user.getId());
		if (dbUser != null) {
			repository.save(user);
			return user;
		}
		throw new UserNotFoundException();
	}

	public boolean removeUser(int id) {
		Optional<User> dbUser = repository.findById(id);
		if (dbUser.isPresent()) {
			repository.delete(dbUser.get());
			return true;
		}
		throw new UserNotFoundException();
	}

	public User getUserById(int id) {
		Optional<User> dbUser = repository.findById(id);
		if (dbUser.isPresent()) {
			return dbUser.get();
		}
		throw new UserNotFoundException();
	}

	public List<User> getAllUser() {
		List<User> list = repository.findAll();
		if (list != null && !list.isEmpty()) {
			return list;
		}
		throw new UserNotFoundException();
	}

}
