package com.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.UserProperty;


public interface IAdminProperty extends MongoRepository<UserProperty, String> {
	List<UserProperty> findByAgentName(String agentName);
}
