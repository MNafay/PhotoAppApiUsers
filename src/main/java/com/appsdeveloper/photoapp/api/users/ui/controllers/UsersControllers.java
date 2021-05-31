package com.appsdeveloper.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.photoapp.api.users.service.UsersService;
import com.appsdeveloper.photoapp.api.users.shared.UserDto;
import com.appsdeveloper.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdeveloper.photoapp.api.users.ui.model.UserResponseModel;

@RestController
@RequestMapping("/users")
public class UsersControllers {

	@Autowired
	private Environment env;

	@Autowired
	private UsersService usersService;

	@GetMapping("/status/check")
	public String healthCheck() {
		return "Service is up and running :" + env.getProperty("local.server.port");
	}

	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<UserResponseModel> createUser(
			@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(createUserRequestModel, UserDto.class);
		UserDto createUser = usersService.createUser(userDto);
		UserResponseModel userResponseModel = modelMapper.map(createUser, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);
	}
}
