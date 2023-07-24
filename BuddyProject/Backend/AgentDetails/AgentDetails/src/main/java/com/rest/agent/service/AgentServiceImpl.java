package com.rest.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.agent.model.Agent;
import com.rest.agent.repository.IAgentRepository;

import java.io.IOException;
import java.util.ArrayList;



@Service
public class AgentServiceImpl implements IAgentService {
	@Autowired
	private IAgentRepository agentrepo;
	
	@Override
	public Agent addAgent(Agent uObj) throws IOException{
		System.out.println(uObj);
		
		Agent photo = new Agent(uObj.getAgentName(), uObj.getAgentPassoword(), uObj.getAgentMobile(),uObj.getAgentEmail(),uObj.getAgentAddress(),uObj.getPropertyId());

        byte[] imageData = uObj.getImage().getData();
        photo.setImage(new org.bson.types.Binary(imageData));

        photo = this.agentrepo.insert(photo);
        return uObj;		
	}


	@Override
	public List<Agent> getAgentByName(String aName) {
		return this.agentrepo.findByAgentNameRegexIgnoreCase(aName);
	}

	@Override
	public List<Agent> getAllAgents() {
		// TODO Auto-generated method stub
		return this.agentrepo.findAll();
	}


	
	@Override
	public List<String> getAllAgentNames() {
	    List<Agent> agents = this.agentrepo.findAll();
	    List<String> agentNames = new ArrayList<>();
	    for (Agent agent : agents) {
	        agentNames.add(agent.getAgentName());
	    }
	    return agentNames;
	}

	@Override
	public Agent getAgentById(String aId) {
		Optional<Agent> AgentOptional =this.agentrepo.findById(aId);
		Agent aObj = null;
		if(AgentOptional.isPresent()){
			System.out.println("Record Exists and sending");
			aObj = AgentOptional.get();
		}else {
			System.out.println("Agent Does not exists!");
		}
		return aObj;
	}

	@Override
	public Agent getAgentByEmail(String aEmail) {
		Agent agent = new Agent();
		 Optional<Agent> agentOptional = this.agentrepo.findByAgentEmail(aEmail);
		    
		    if (agentOptional.isPresent()) {
		        agent = agentOptional.get();
		        // Do something with the agent object
		        System.out.println(agent);
		    } else {
		        // Agent with the specified email not found
		        System.out.println("Agent not found");
		    }
		return agent;
	}

	@Override
	public boolean deleteAgent(String aid) {
		System.out.println("Delete Agent: "+aid);
		Optional<Agent> userOptional =this.agentrepo.findById(aid);
		if(userOptional.isPresent()) {
			System.out.println("Record DO NOT Exists and Deleting");
			this.agentrepo.deleteById(aid);
			return false;
			
		}else {
			System.out.println("Error!");
			return true;
		}
	}


	@Override
	public boolean UpdateAgent(Agent aObj, String aid) {
		Optional<Agent> userOptional = this.agentrepo.findById(aid);
		if(userOptional.isPresent()) {
			System.out.println("Record DOES Exist, Updating");
			Agent existingAgent = userOptional.get();
			existingAgent.setAgentAddress(aObj.getAgentAddress());
			existingAgent.setAgentEmail(aObj.getAgentEmail());
			existingAgent.setAgentMobile(aObj.getAgentMobile());
			existingAgent.setAgentName(aObj.getAgentName());
			existingAgent.setAgentPassoword(aObj.getAgentPassoword());
			this.agentrepo.save(existingAgent);
			return true;
			
		}else {
			System.out.println("Error!");
			return false;
		}
	}




	
}
