package com.rest.agent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.agent.model.Agent;

@Repository
public interface IAgentRepository extends MongoRepository<Agent, String> {

	List<Agent> findByAgentNameRegexIgnoreCase(String aName);
	Optional<Agent> findByAgentEmail(String agentEmail);
}
