package com.appsdeveloper.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloper.photoapp.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);
	
	UserDto getUserDetailByEmail(String email);
}
