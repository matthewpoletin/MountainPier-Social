package com.mountainpier.social.service;

import com.mountainpier.social.domain.Relations;
import com.mountainpier.social.domain.User;
import com.mountainpier.social.repository.UserRepository;
import com.mountainpier.social.web.model.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<User> getUsers(Integer page, Integer size) {
		return userRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<User> getUsersWithUsername(String username, Integer page, Integer size) {
		return userRepository.getUsersByUsernameContainingIgnoreCase(username, PageRequest.of(page, size));
	}
	
	@Override
	@Transactional
	public User createUser(UserRequest userRequest) {
		User user = new User()
			.setUsername(userRequest.getUsername())
			.setAvatar(userRequest.getAvatar())
			.setRegEmail(userRequest.getRegEmail())
			.setRegDate(userRequest.getRegDate())
			.setBirthDate(userRequest.getBirthDate())
			.setStatus(userRequest.getStatus());
		return userRepository.save(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserById(Integer userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new EntityNotFoundException("User '{" + userId + "}' not found"));
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsernameIgnoreCase(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserByRegEmail(String regEmail) {
		return userRepository.getUserByRegEmailIgnoreCase(regEmail);
	}
	
	@Override
	@Transactional
	public User updateUserById(Integer userId, UserRequest userRequest) {
		User user = this.getUserById(userId);
		user.setUsername(userRequest.getUsername() != null ? userRequest.getUsername() : user.getUsername());
		user.setAvatar(userRequest.getAvatar() != null ? userRequest.getAvatar() : user.getAvatar());
		user.setRegEmail(userRequest.getRegEmail() != null ? userRequest.getRegEmail() : user.getRegEmail());
		user.setRegDate(userRequest.getRegDate() != null ? userRequest.getRegDate() : user.getRegDate());
		user.setBirthDate(userRequest.getBirthDate() != null ? userRequest.getBirthDate() : user.getBirthDate());
		user.setStatus(userRequest.getStatus() != null ? userRequest.getStatus() : user.getStatus());
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<User> getFriendsOfUserById(Integer userId, Integer page, Integer size) {
		User user = this.getUserById(userId);
		List<Relations> relations = user.getRelated();
		List<User> friends = new ArrayList<>();
		relations.forEach(relation -> {
			if (relation.getType().equals("friend"))
				friends.add(relation.getUserB());
		});
		return new PageImpl<User>(friends, new PageRequest(page, size), friends.size());
	}
	
}
