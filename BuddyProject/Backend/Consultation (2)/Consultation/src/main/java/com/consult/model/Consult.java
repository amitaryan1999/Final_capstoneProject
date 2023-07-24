package com.consult.model;

import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;


@Document
public class Consult {
	@Id
	public String consultId;
	public String lname;
	public String fname;
	public String email;
	public String message;
	
	public Consult(String consultId, String lname, String fname, String email, String message) {
		super();
		this.consultId = consultId;
		this.lname = lname;
		this.fname = fname;
		this.email = email;
		this.message = message;
	}

	public Consult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getConsultId() {
		return consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Consult [consultId=" + consultId + ", lname=" + lname + ", fname=" + fname + ", email=" + email
				+ ", message=" + message + "]";
	}
	
	
	
}
