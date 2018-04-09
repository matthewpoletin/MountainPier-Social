package com.mountainpier.social.repository;

import com.mountainpier.social.domain.Collection;

import com.mountainpier.social.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CollectionRepository
		extends JpaRepository<Collection, Integer> {
	
	List<Collection> findCollectionsByGameId(UUID gameId);
	
	List<Collection> findCollectionsByUser(User user);
	
	void removeCollectionByGameIdAndUser(UUID gameId, User user);
	
}
