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

}
