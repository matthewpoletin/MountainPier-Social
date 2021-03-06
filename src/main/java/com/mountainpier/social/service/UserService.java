package com.mountainpier.social.service;

import com.mountainpier.social.domain.Relation;
import com.mountainpier.social.domain.User;
import com.mountainpier.social.web.model.UserRequest;

import org.springframework.data.domain.Page;
import java.util.List;
import java.util.UUID;

public interface UserService {
	Page<User> getUsers(Integer page, Integer size);
	Page<User> getUsersWithUsername(String username, Integer page, Integer size);
	User createUser(UserRequest	userRequest);
	User getUserById(UUID userId);
	User getUserByUsername(String username);
	User getUserByRegEmail(String regEmail);
	User updateUserById(UUID userId, UserRequest userRequest);
	void deleteUserById(UUID userId);
	
	Page<User> getFriendsOfUserById(UUID userId, Integer page, Integer size);
	Relation addFriendByIdToUserById(UUID userId, UUID friendId);
	void removeFriendByIdToUserById(UUID userId, UUID friendId);
	Relation getRelationOfUsersById(UUID userAId, UUID userBId);
	
	List<UUID> getGamesOfUserById(UUID userId);
}
