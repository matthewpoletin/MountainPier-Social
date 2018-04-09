package com.mountainpier.social.service;

import com.mountainpier.social.domain.Collection;
import com.mountainpier.social.domain.User;

import com.mountainpier.social.repository.CollectionRepository;
import com.mountainpier.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CollectionServiceImpl implements CollectionService {
	
	private final CollectionRepository collectionRepository;
	
	private final UserRepository userRepository;

	@Autowired
	public CollectionServiceImpl(CollectionRepository collectionRepository,
								 UserRepository userRepository) {
		this.collectionRepository = collectionRepository;
		this.userRepository = userRepository;
	}
	
	// TODO: switch to paginated response
	@Override
	@Transactional(readOnly = true)
	public List<User> getOwnersOfGameById(UUID gameId, Integer page, Integer size) {
		List<Collection> collections = this.collectionRepository.findCollectionsByGameId(gameId);
		List<User> users = new ArrayList<>();
		collections.forEach(collection -> {
			users.add(collection.getUser());
		});
		return users;
	}
	
	@Override
	@Transactional
	public void addGameByIdToUser(UUID gameId, User user) {
		Collection collection = new Collection()
			.setGameId(gameId)
			.setUser(user);
		this.collectionRepository.save(collection);
	}
	
	@Override
	@Transactional
	public void removeGameByIdFromUserById(UUID gameId, UUID userId) {
		User user = this.userRepository.getUserById(userId);
		this.collectionRepository.removeCollectionByGameIdAndUser(gameId, user);
	}
	
}
