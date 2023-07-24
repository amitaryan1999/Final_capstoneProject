//package com.api.Services;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.api.Fiegn.IGTConsumer;
//import com.api.model.User;
//
//@Service
//public class IGTServiceImp implements IGTService{
//	
//    @Autowired
//	private IGTConsumer userConsumer;
//	
//	
//	@Override
//	public String validateUser(User uObj) {
//		
//		User userObj = this.userConsumer.getByEmailHandler(uObj.getEmail());
//		if(userObj != null) {
//			if(userObj.getPassword().equals(uObj.getPassword())) {
//				return "User Authenticated Successfully!!";
//			}else {
//				System.out.println("Wrong Password");
//				return "Wrong Password";
//			}
//		}else {
//			System.out.println("User Not Found!");
//			return "User Not Found!";
//		}
//	}
//
//}
