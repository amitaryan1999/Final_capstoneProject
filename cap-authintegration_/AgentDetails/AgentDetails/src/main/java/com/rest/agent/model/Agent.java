package com.rest.agent.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Agent {
	@Id
	private String agentId;
	
	private String agentName;
	private String agentPassoword;
	private String agentMobile;
	private String agentEmail;
	private String agentAddress;
	private String propertyId;
	private Binary image;
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentPassoword() {
		return agentPassoword;
	}
	public void setAgentPassoword(String agentPassoword) {
		this.agentPassoword = agentPassoword;
	}
	public String getAgentMobile() {
		return agentMobile;
	}
	public void setAgentMobile(String agentMobile) {
		this.agentMobile = agentMobile;
	}
	public String getAgentEmail() {
		return agentEmail;
	}
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	public Agent() {
		super();
	}
	public Agent(String agentName, String agentPassoword, String agentMobile, String agentEmail, String agentAddress,
			String propertyId) {
		super();
		this.agentName = agentName;
		this.agentPassoword = agentPassoword;
		this.agentMobile = agentMobile;
		this.agentEmail = agentEmail;
		this.agentAddress = agentAddress;
		this.propertyId = propertyId;
	}
	public Agent(Binary image) {
		super();
		this.image = image;
	}
	
	
}
