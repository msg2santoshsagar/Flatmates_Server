package com.alife.flatmates.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alife.flatmates.server.domain.Group;

/**
 * Spring Data JPA repository for the Group entity.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {


}
