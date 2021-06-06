package com.appsdeveloper.photoapp.api.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.photoapp.api.users.data.UserEntity;

@Repository
public interface UsersRepositorty extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

}
