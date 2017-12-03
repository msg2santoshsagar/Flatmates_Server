package com.alife.flatmates.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alife.flatmates.server.domain.GroupUser;

/**
 * Spring Data JPA repository for the Group User entity.
 */
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {


}
