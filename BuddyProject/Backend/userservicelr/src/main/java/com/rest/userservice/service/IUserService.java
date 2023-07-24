package com.rest.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.userservice.model.User;

@Service
public interface IUserService {

	
	

	

	public String saveRegUser(User user);

	

	public List<User> getAllRegUser();

}
