package com.alife.flatmates.server.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alife.flatmates.server.domain.Group;
import com.alife.flatmates.server.domain.User;

/**
 * Spring Data JPA repository for the Group entity.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {

	@Query("Select g from Group g where g.id in ( select gu.group.id from GroupUser gu where gu.user = :user  ) ")
	List<Group> findGroupListForUser(@Param("user") User user );


}
