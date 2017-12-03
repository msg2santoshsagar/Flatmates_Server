package com.alife.flatmates.server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alife.flatmates.server.domain.GroupUser;
import com.alife.flatmates.server.repository.GroupUserRepository;

@Service
public class GroupUserService {
	
	private final Logger log = LoggerFactory.getLogger(GroupUserService.class);
	
	private final GroupUserRepository groupUserRepository;
	
	
	public  GroupUserService(GroupUserRepository groupUserRepository) {
		this.groupUserRepository = groupUserRepository;
	}
	
	@Transactional
	public GroupUser save(GroupUser groupUser){
		return groupUserRepository.save(groupUser);
	}
	
	

}
