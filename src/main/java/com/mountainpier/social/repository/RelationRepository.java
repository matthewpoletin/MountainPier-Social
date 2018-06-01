package com.mountainpier.social.repository;

import com.mountainpier.social.domain.Relation;

import com.mountainpier.social.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository
		extends JpaRepository<Relation, Integer> {
	
	void deleteRelationByUserAAndUserBAndType(User userA, User userB, String type);

	Relation getRelationByUserAAndUserB(User userA, User userB);
	
}
