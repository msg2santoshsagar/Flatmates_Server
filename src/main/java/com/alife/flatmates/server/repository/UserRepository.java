package com.alife.flatmates.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.alife.flatmates.server.domain.User;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);

}
