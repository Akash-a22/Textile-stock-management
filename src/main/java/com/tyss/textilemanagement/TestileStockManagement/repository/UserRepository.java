package com.tyss.textilemanagement.TestileStockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.tyss.textilemanagement.TestileStockManagement.dto.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=?1")
	User findByEmail(String email);

}
