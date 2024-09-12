package com.project.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Users;

public interface UserReponsitory extends JpaRepository<Users, Long> {
	Users findByUserName(String userName);
}
