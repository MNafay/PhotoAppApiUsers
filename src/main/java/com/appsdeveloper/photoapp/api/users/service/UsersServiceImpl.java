package com.appsdeveloper.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloper.photoapp.api.users.data.UserEntity;
import com.appsdeveloper.photoapp.api.users.repository.UsersRepositorty;
import com.appsdeveloper.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepositorty usersRepositorty;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		usersRepositorty.save(userEntity);
		UserDto createdUser = modelMapper.map(userEntity, UserDto.class);
		return createdUser;
	}

}
