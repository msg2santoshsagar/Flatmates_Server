package com.alife.flatmates.server.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * A Group User entity.
 */
@Entity
@Table(name = "group_user")
public class GroupUser extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "group_id")
	private Group group;

	@NotNull
	@Column(name = "user_role")
	private String authority;

	@NotNull
	@Column(nullable = false)
	private boolean active = true;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}

	public GroupUser setUser(User user) {
		this.user = user;
		return this;
	}

	public Group getGroup() {
		return group;
	}

	public GroupUser setGroup(Group group) {
		this.group = group;
		return this;
	}

	public String getAuthority() {
		return authority;
	}

	public GroupUser setAuthority(String authority) {
		this.authority = authority;
		return this;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "GroupUser [id=" + id + ", user=" + user + ", group=" + group + ", authority=" + authority + ", active="
				+ active + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}



}