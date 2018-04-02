package com.mountainpier.social.repository;

import com.mountainpier.social.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository
		extends JpaRepository<User, Integer> {
	
	User getUserById(UUID uuid);
	
	void deleteUserById(UUID uuid);
	
	User getUserByUsernameIgnoreCase(String username);
	
	User getUserByRegEmailIgnoreCase(String regEmail);
	
	Page<User> getUsersByUsernameContainingIgnoreCase(String username, Pageable pageable);
	
}
