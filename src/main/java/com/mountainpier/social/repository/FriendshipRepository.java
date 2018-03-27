package com.mountainpier.social.repository;

import com.mountainpier.social.domain.Relations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository
	extends JpaRepository<Relations, Integer> {
}
