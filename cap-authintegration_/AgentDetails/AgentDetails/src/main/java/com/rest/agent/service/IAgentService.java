package com.rest.agent.service;

import java.io.IOException;
import java.util.List;

import com.rest.agent.model.Agent;

public interface IAgentService {
	public Agent addAgent(Agent aObj) throws IOException;
	public boolean UpdateAgent(Agent aObj, String aid);
	public List<Agent> getAgentByName(String aName);
	public Agent getAgentById(String aId);
	public Agent getAgentByEmail(String aEmail);
	public List<Agent> getAllAgents();
	public boolean deleteAgent(String aid);
	public List<String> getAllAgentNames();
}
