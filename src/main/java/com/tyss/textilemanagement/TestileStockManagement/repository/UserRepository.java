package com.tyss.textilemanagement.TestileStockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.textilemanagement.TestileStockManagement.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=?1")
	User findByEmail(String email);

}
