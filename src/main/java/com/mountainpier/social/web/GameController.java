package com.mountainpier.social.web;


import com.mountainpier.social.service.CollectionService;
import com.mountainpier.social.web.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(GameController.gameBaseURI)
public class GameController {
	
	static final String gameBaseURI = "/api/social";
	
	private final CollectionService collectionService;
	
	@Autowired
	GameController(CollectionService collectionService) {
		this.collectionService = collectionService;
	}
	
	@RequestMapping(value = "/games/{gameId}/users", method = RequestMethod.GET)
	public Page<UserResponse> getOwnersOfGameById(@PathVariable("gameId") final UUID gameId,
												  @RequestParam(value = "page", defaultValue = "0") Integer page,
												  @RequestParam(value = "size", defaultValue = "25") Integer size) {
		return collectionService.getOwnersOfGameById(gameId, page, size)
			.map(UserResponse::new);
	}
	
}
