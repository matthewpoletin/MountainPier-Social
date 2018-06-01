package com.mountainpier.social.web;

import com.mountainpier.social.domain.User;
import com.mountainpier.social.service.CollectionService;
import com.mountainpier.social.service.UserService;
import com.mountainpier.social.web.model.RelationResponse;
import com.mountainpier.social.web.model.UserRequest;
import com.mountainpier.social.web.model.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UserController.userBaseURI)
public class UserController {

	static final String userBaseURI = "/api/social";

	private final UserService userService;
	private final CollectionService collectionService;
	
	@Autowired
	UserController(UserService userService,
				   CollectionService collectionService) {
		this.userService = userService;
		this.collectionService = collectionService;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Page<UserResponse> getUsers(@RequestParam(value = "page", required = false) Integer page,
									   @RequestParam(value = "size", required = false) Integer size,
									   @RequestParam(value = "username", required = false) String username) {
		page = page != null ? page : 0;
		size = size != null ? size : 25;
		Page<User> userPage;
		if (username != null) userPage = userService.getUsersWithUsername(username, page, size);
		else userPage = userService.getUsers(page, size);
		return userPage
			.map(UserResponse::new);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserResponse createUser(@Valid @RequestBody UserRequest userRequest,
								   HttpServletResponse response) {
		User user = userService.createUser(userRequest);
		response.addHeader(HttpHeaders.LOCATION, userBaseURI + "/users/" + user.getId().toString());
		return new UserResponse(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserResponse getUserById(@PathVariable("userId") final UUID userId) {
		return new UserResponse(userService.getUserById(userId));
	}
	
	@RequestMapping(value = "/users/by", method = RequestMethod.GET)
	public UserResponse getUserBy(@RequestParam(name = "username", required = false) final String username,
								  @RequestParam(name = "email", required = false) final String email,
								  HttpServletResponse response) {
		User user;
		if (username != null && username.length() > 0) {
			user = userService.getUserByUsername(username);
		} else if (email != null && email.length() > 0) {
			user = userService.getUserByRegEmail(email);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		if (user != null) {
			return new UserResponse(user);
		} else {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return null;
		}
	}
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PATCH)
	public UserResponse updateUser(@PathVariable("userId") final UUID userId,
								   @RequestBody @Valid UserRequest userRequest) {
		return new UserResponse(userService.updateUserById(userId, userRequest));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") final UUID userId) {
		userService.deleteUserById(userId);
	}
	
	@RequestMapping(value = "/users/{userId}/friends", method = RequestMethod.GET)
	public Page<UserResponse> getFriendsOfUserById(@PathVariable("userId") final UUID userId,
												   @RequestParam(value = "page", required = false) Integer page,
												   @RequestParam(value = "size", required = false) Integer size) {
		page = page != null ? page : 0;
		size = size != null ? size : 25;
		return userService.getFriendsOfUserById(userId, page, size)
			.map(UserResponse::new);
	}
	
	@RequestMapping(value = "/users/{userId}/friends/{friendId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public RelationResponse addFriendByIdToUserById(@PathVariable("userId") final UUID userId,
													@PathVariable("friendId") final UUID friendId) {
		return new RelationResponse(this.userService.addFriendByIdToUserById(userId, friendId));
	}
	
	@RequestMapping(value = "/users/{userId}/friends/{friendId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeFriendByIdToUserById(@PathVariable("userId") final UUID userId,
										   @PathVariable("friendId") final UUID friendId) {
		this.userService.removeFriendByIdToUserById(userId, friendId);
	}
	
	@RequestMapping(value = "/users/{userAId}/relation/{userBId}", method = RequestMethod.GET)
	public RelationResponse getRelationOfUsers(@PathVariable("userAId") final UUID userAId,
											   @PathVariable("userBId") final UUID userBId) {
		return new RelationResponse(this.userService.getRelationOfUsersById(userAId, userBId));
	}
	
	@RequestMapping(value = "/users/{userId}/games", method = RequestMethod.GET)
	public List<UUID> getGamesOfUserById(@PathVariable("userId") final UUID userId,
										 @RequestParam(value = "page", required = false) Integer page,
										 @RequestParam(value = "size", required = false) Integer size) {
		page = page != null ? page : 0;
		size = size != null ? size : 25;
		return this.userService.getGamesOfUserById(userId);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/users/{userId}/games/{gameId}", method = RequestMethod.POST)
	public void addGameByIdToUserById(@PathVariable("userId") final UUID userId,
									  @PathVariable("gameId") final UUID gameId) {
		User user = this.userService.getUserById(userId);
		this.collectionService.addGameByIdToUser(gameId, user);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/users/{userId}/games/{gameId}", method = RequestMethod.DELETE)
	public void removeGameByIdFromUserById(@PathVariable("userId") final UUID userId,
										   @PathVariable("gameId") final UUID gameId) {
		this.collectionService.removeGameByIdFromUserById(gameId, userId);
	}
	
}
