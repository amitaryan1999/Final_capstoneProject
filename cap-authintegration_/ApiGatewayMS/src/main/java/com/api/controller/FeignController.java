package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.feingconfig.UserRestConsumer;
import com.api.model.User;
import com.api.service.AuthService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin("*")
@RequestMapping("/path")
public class FeignController {
	@Autowired
	private AuthService authService;

	@Autowired
	private UserRestConsumer restConsumer;

	private ResponseEntity responseEntity;

	private Map<String, String> map = new HashMap<>();

	@GetMapping("/")
	public String Started() {
		return "Auth Service started";
	}

	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User uObj) {
		try {
			System.out.println(uObj);
			String jwtToken = generateToken(uObj);
			System.out.println(jwtToken);
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
		System.out.println("INSIDE GENERATE TOKEN");
		String jwtToken = "";
		if (uObj.getEmail() == null || uObj.getPassword() == null) {
			throw new ServletException("Please Send Valid credentials");

		}
		boolean flag = this.authService.validateUser(uObj);
		if (!flag) {
			throw new ServletException("Invalid Credentials");

		} else {
			jwtToken = Jwts.builder().setSubject(uObj.getEmail()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
			System.out.println(jwtToken);
			return jwtToken;

		}
	}

}
