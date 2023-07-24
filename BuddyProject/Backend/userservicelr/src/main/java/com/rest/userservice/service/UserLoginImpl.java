package com.rest.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.userservice.model.User;
import com.rest.userservice.repository.IUserRepository;

@Service
public class UserLoginImpl implements IUserLoginService{

	@Autowired
	 private IUserRepository iUserLogRepository;
	
	
	@Override
	public boolean getDetailLogUser(User user) {
		List<User> uObj = iUserLogRepository.findAll();
		
		for (User u : uObj) {
			if(u.getEmail().equals(user.getEmail())) {
				if(u.getPassword().equals(user.getPassword())) {
					System.out.println("Successfully logged in!");
					return true;
				}else {
					System.out.println("Invalid Passowrd!");
					return false;
				}
			}
		}
		return false;
	}


	@Override
	public boolean validateUser(User uObj) {
		// TODO Auto-generated method stub
	User regDetails = this.iUserLogRepository.getUserByEmailHandler(uObj.getEmail());
		
		if(uObj.getEmail().equals(regDetails.getEmail()) && uObj.getPassword().equals(regDetails.getPassword())) {
			System.out.println("Successfully logged in!");
			return true;
		}
		else
		{
			System.out.println("Invalid Passowrd!");
			return false;
		}
	}
}
