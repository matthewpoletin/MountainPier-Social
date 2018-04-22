package com.mountainpier.social.service;

import com.mountainpier.social.domain.User;

import org.springframework.data.domain.Page;
import java.util.UUID;

public interface CollectionService {
	
	Page<User> getOwnersOfGameById(UUID gameId, Integer page, Integer size);
	
	void addGameByIdToUser(UUID gameId, User user);
	
	void removeGameByIdFromUserById(UUID gameId, UUID userId);
	
}
