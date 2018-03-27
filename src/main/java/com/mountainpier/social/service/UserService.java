package com.mountainpier.social.service;

import com.mountainpier.social.domain.User;
import com.mountainpier.social.web.model.UserRequest;

import org.springframework.data.domain.Page;

public interface UserService {
	Page<User> getUsers(Integer page, Integer size);
	Page<User> getUsersWithUsername(String username, Integer page, Integer size);
	User createUser(UserRequest	userRequest);
	User getUserById(Integer userId);
	User getUserByUsername(String username);
	User getUserByRegEmail(String regEmail);
	User updateUserById(Integer userId, UserRequest userRequest);
	void deleteUserById(Integer userId);
	
	Page<User> getFriendsOfUserById(Integer userId, Integer page, Integer size);
}
