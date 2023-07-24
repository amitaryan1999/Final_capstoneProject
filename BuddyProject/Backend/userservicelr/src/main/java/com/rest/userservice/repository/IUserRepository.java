package com.rest.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.userservice.model.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	

	List<User> findAll();

	public User getUserByEmailHandler( String email);

}
