package com.mountainpier.social.repository;

import com.mountainpier.social.domain.Relation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository
		extends JpaRepository<Relation, Integer> {
}
