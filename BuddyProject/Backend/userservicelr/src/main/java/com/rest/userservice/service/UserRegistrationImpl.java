package com.rest.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.userservice.model.User;
import com.rest.userservice.repository.IUserRepository;

@Service
public class UserRegistrationImpl implements IUserService {
	@Autowired
	 IUserRepository iUserRepository;

	@Override
	public String saveRegUser(User user) {
		// TODO Auto-generated method stub
		iUserRepository.save(user);
		return "user id : "+user.getUserId()+" is saved successfully...";
	}
	@Override
	public List<User> getAllRegUser() {
		// TODO Auto-generated method stub
		return iUserRepository.findAll();
	}
}