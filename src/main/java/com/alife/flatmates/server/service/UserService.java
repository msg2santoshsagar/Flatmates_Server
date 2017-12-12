package com.alife.flatmates.server.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public Optional<User> findOneByLogin(String login){
		return userRepository.findOneByLogin(login);
	}
	
	@Transactional(readOnly=true)
	public User findUserObjectWithId(String login){
		Long userId =  userRepository.findOneUserIdByLogin(login);
		return new User().setId(userId);
	}
	
	@Transactional(readOnly=true)
	public User findOneBasicDetailByLogin(String login){
		return userRepository.findOneBasicDetailByLogin(login);
	}
	
	@Transactional(readOnly=true)
	public User findUserObjectByEmailWithId(String email){
		Long userId =  userRepository.findOneUserIdByEmail(email);
		return new User().setId(userId);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

}
