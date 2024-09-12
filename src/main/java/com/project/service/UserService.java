package com.project.service;

import com.project.models.Users;

public interface UserService {
	Users findByUserName(String userName);

}
