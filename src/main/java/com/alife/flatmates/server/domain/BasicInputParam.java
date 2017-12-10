package com.alife.flatmates.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BasicInputParam {

	private String userName;
	private Long   groupId;
	
	public String getUserName() {
		return userName;
	}
	

	public Long getGroupId() {
		return groupId;
	}


	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public BasicInputParam setUserName(String userName) {
		if(userName != null){
			userName = userName.trim().toLowerCase();
		}
		this.userName = userName;
		return this;
	}


	@Override
	public String toString() {
		return "BasicInputParam [userName=" + userName + ", groupId=" + groupId + "]";
	}
	
	

}