package com.appsdeveloper.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message="First name cannot be null")
	@Size(min=2, message="First name cannot be less than 2 caharacter")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2, message="Last name cannot be less than 2 caharacter")
	private String lastName;
	
	@NotNull(message="Password cannot be null")
	@Size(min=2, max=16, message="Password must be between 2 to 16 character")
	private String password;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
