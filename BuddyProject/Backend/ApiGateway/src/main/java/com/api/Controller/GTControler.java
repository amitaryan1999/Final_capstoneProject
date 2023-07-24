//
//package com.api.Controller;
//
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.api.Services.IGTService;
//import com.api.model.User;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.servlet.ServletException;
//
//@RestController
//@RequestMapping("api/login")
//public class GTControler {
//	
//	@Autowired
//	private IGTService userlogin;
//	
//
//	private Map<String, String> map = new HashMap<>();
//	
//	@GetMapping("/validate")
//	public ResponseEntity<?> validateUserHandler(@RequestBody User uObj){
//		try {
//			String jwtToken=generateToken(uObj);
//			map.put("message", "User Successfully LoggedIn");
//			map.put("token", jwtToken);
//		}catch(Exception e) {
//			map.put("message", e.getMessage());
//
//            map.put("token", null);
//
//            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
//		}
//		
//		 return new ResponseEntity<>(map, HttpStatus.OK);
//	}
//	
//	private String generateToken(User UObj) throws ServletException{
//		String jwtToken = "";
//		String flag = this.userlogin.validateUser(UObj);
//		if(flag == "User Not Found!") {
//			throw new ServletException("Invalid Credentials");
//		}else {
//			jwtToken=Jwts.builder().setSubject(UObj.getEmail()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3000000)).signWith(SignatureAlgorithm.HS256, "secret key").compact();
//		}
//		return jwtToken;
//	}
//}
