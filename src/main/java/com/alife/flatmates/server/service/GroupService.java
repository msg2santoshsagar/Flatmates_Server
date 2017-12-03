package com.alife.flatmates.server.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alife.flatmates.server.domain.Group;
import com.alife.flatmates.server.repository.GroupRepository;

@Service
public class GroupService {
	
	private final Logger log = LoggerFactory.getLogger(GroupService.class);
	
	private final GroupRepository groupRepository;
	
	public  GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
	
	@Transactional
	public Group save(Group group){
		return groupRepository.save(group);
	}
	
	@Transactional(readOnly=true)
	public List<Group> findAll(){
		log.debug("Request To find all group list");
		return groupRepository.findAll();
	}
	
	

}
