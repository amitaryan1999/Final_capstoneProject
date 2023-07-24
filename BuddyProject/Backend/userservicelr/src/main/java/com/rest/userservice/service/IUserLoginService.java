package com.rest.userservice.service;

import org.springframework.stereotype.Service;

import com.rest.userservice.model.User;

@Service
public interface IUserLoginService {

	

	public boolean getDetailLogUser(User uObj);
	boolean validateUser(User uObj);

}
