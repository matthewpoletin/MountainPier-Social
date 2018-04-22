package com.mountainpier.social.web;


import com.mountainpier.social.service.CollectionServiceImpl;
import com.mountainpier.social.web.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(GameController.gameBaseURI)
public class GameController {
	
	static final String gameBaseURI = "/api/social";
	
	private final CollectionServiceImpl collectionService;
	
	@Autowired
	GameController(CollectionServiceImpl collectionService) {
		this.collectionService = collectionService;
	}
	
	@RequestMapping(value = "/games/{gameId}/users", method = RequestMethod.GET)
	public Page<UserResponse> getOwnersOfGameById(@PathVariable("gameId") final UUID gameId,
												  @RequestParam(value = "page", required = false) Integer page,
												  @RequestParam(value = "size", required = false) Integer size) {
		page = page != null ? page : 0;
		size = size != null ? size : 25;
		return collectionService.getOwnersOfGameById(gameId, page, size)
			.map(UserResponse::new);
	}
	
}
