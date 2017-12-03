package com.alife.flatmates.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alife.flatmates.server.domain.User;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByLogin(String login);

	@Query("Select u.id from User u where u.login = :login  ")
	Long findOneUserIdByLogin(@Param("login") String login);

}
