package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Responsitory.UserReponsitory;
import com.project.models.Users;
import com.project.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserReponsitory responsitory;
	@Override
	public Users findByUserName(String userName) {
		// TODO Auto-generated method stub
		return responsitory.findByUserName(userName);
	}

}
