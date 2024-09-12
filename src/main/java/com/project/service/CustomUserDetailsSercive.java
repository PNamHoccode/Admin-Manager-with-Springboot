package com.project.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.models.CustomUserDetails;
import com.project.models.UserRole;
import com.project.models.Users;
@Service
public class CustomUserDetailsSercive implements UserDetailsService {
		@Autowired
		private UserService userservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Users user= userservice.findByUserName(username);
	if(user==null) {
		throw new UsernameNotFoundException("Sai");
	}
	Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
    Set<UserRole> roles = user.getUserRoles();
    for (UserRole userRole : roles) {
		grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
	}

		return new CustomUserDetails(user, grantedAuthoritySet);
	}

}
