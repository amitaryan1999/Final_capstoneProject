package com.rest.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rest.model.UserProperty;


public interface IAdminPropertyService {
	
	public UserProperty updateProperty(UserProperty nobj,String nid);
	
	public UserProperty getPropertyById(String nid);
	
	public List<UserProperty> getAllProperty();
	
	public boolean delProperty(String nid);

	public UserProperty saveProperty(UserProperty property) throws IOException;
	List<UserProperty> getPropertiesByAgentName(String agentName);
}
