package com.mountainpier.social.service;

import com.mountainpier.social.domain.User;

import java.util.List;
import java.util.UUID;

public interface CollectionService {
	
	List<User> getOwnersOfGameById(UUID gameId, Integer page, Integer size);
	
	void addGameByIdToUser(UUID gameId, User user);
	
	void removeGameByIdFromUserById(UUID gameId, UUID userId);
	
}
