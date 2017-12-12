package com.alife.flatmates.server.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alife.flatmates.server.domain.BasicInputParam;
import com.alife.flatmates.server.domain.Group;
import com.alife.flatmates.server.service.GroupService;

@RestController
@RequestMapping(value="/api/group")
public class GroupController {

	private final Logger log = LoggerFactory.getLogger(GroupController.class);

	private final GroupService groupService;

	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Group save(@RequestBody Group group){
		log.debug("Request to save Group {}" , group);
		return groupService.saveWithCreatingGroupUser(group);
	}

	@PostMapping(value="/getGroupList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Group> getGroupList(){
		return groupService.findGroupListForLoggedInUser();
	}
	
	@PostMapping(value="/addUserToGroup",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean addUserToGroup(@RequestBody BasicInputParam param){
		return groupService.addUserToGroup(param);
	}


}
