package com.api.service;

import org.springframework.stereotype.Service;

import com.api.model.User;
@Service
public interface AuthService {

	boolean validateUser(User uObj);

}
