package com.alife.flatmates.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alife.flatmates.server.domain.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
