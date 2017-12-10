package com.alife.flatmates.server.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alife.flatmates.server.domain.BasicInputParam;
import com.alife.flatmates.server.domain.Group;
import com.alife.flatmates.server.domain.GroupUser;
import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.domain.constants.AuthoritiesConstants;
import com.alife.flatmates.server.repository.GroupRepository;
import com.alife.flatmates.server.security.SecurityUtils;

@Service
public class GroupService {

	private final Logger log = LoggerFactory.getLogger(GroupService.class);

	private final GroupRepository groupRepository;

	private final UserService  userService;

	private final GroupUserService groupUserService;

	public  GroupService(GroupRepository groupRepository,UserService userService,GroupUserService groupUserService) {
		this.groupRepository = groupRepository;
		this.userService     = userService;
		this.groupUserService = groupUserService;
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

	@Transactional
	public Group saveWithCreatingGroupUser(Group group) {
		String userLogin = SecurityUtils.getCurrentUserLogin();
		User   user      = userService.findUserObjectWithId(userLogin.toLowerCase());
		group 			 = groupRepository.save(group);

		GroupUser groupUser = new GroupUser();
		groupUser.setUser(user).setGroup(group).setAuthority(AuthoritiesConstants.GROUP_ADMIN);

		groupUser = groupUserService.save(groupUser);
		
		group.getGroupUser().add(groupUser);

		return groupRepository.findOne(group.getId());
	}

	@Transactional(readOnly=true)
	public List<Group> findGroupListForUser(BasicInputParam param) {
		String userName = param.getUserName();
		System.out.println(" OWNER : "+userName);
		User   user      = userService.findUserObjectWithId(userName);
		
		return groupRepository.findGroupListForUser( user );
	}

	public boolean addUserToGroup(BasicInputParam param) {
		String userName = param.getUserName();
		System.out.println(" USER NAME : "+userName);
		User   user      = userService.findUserObjectWithId(userName);
		
		Group group = new Group().setId(param.getGroupId());
		
		GroupUser groupUser = new GroupUser();
		groupUser.setUser(user).setGroup(group).setAuthority(AuthoritiesConstants.GROUP_USER);

		groupUser = groupUserService.save(groupUser);
		
		return true;
	}
	
	



}
