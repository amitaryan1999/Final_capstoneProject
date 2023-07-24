package com.rest.userservice.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.userservice.model.User;
import com.rest.userservice.service.IUserLoginService;
import com.rest.userservice.service.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@CrossOrigin
@RequestMapping("/user/")
public class UserController {

	@Autowired
	IUserService iUserService;
//	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/regUser/save")
	public ResponseEntity<String> createUser(@RequestBody User user){
		return new ResponseEntity<String>(iUserService.saveRegUser(user),HttpStatus.OK);
	}
	@GetMapping("/regUser/getAll")
	public ResponseEntity<List<User>> readAllUsers(){
		return new ResponseEntity<List<User>>(iUserService.getAllRegUser(),HttpStatus.OK);
	}
	
	@Autowired
	IUserLoginService iUserLogService;
	private ResponseEntity<?> responseEntity;
	
//	@PostMapping("/logUser/getUser")
//	public ResponseEntity<Boolean> readAllUsers(@RequestBody User uObj) {
//	    boolean allUsers = this.iUserLogService.getDetailLogUser(uObj);
//	    return ResponseEntity.ok(allUsers);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User uObj) {
		try {
			String jwtToken = generateToken(uObj);
			map.put("message", "User Successfully LoggedIn");
			map.put("token", jwtToken);
		} catch (Exception e) {
			map.put("message", "Account Not Exist");
			map.put("token", null);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	private String generateToken(User uObj) throws ServletException {
		String jwtToken = "";
		if (uObj.getEmail() == null || uObj.getPassword() == null) {
			throw new ServletException("Please Send Valid credentials");

		}
		boolean flag = this.iUserLogService.validateUser(uObj);
		if (!flag) {
			throw new ServletException("Invalid Credentials");

		} else {
			jwtToken = Jwts.builder().setSubject(uObj.getEmail()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS256, "secrete key").compact();
			return jwtToken;

		}
	}

}