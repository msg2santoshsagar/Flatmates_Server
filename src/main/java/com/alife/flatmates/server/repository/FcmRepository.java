package com.alife.flatmates.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alife.flatmates.server.domain.FCM;
import com.alife.flatmates.server.domain.User;

public interface FcmRepository extends JpaRepository<FCM, Long> {

	@Query("Select f.id from FCM f where f.user = :user and f.deviceType = :deviceType ")
	Long findOne(@Param("user") User user, @Param("deviceType") String deviceType);

}
