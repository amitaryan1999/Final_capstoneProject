package com.rest.agent.controller;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.agent.model.Agent;
import com.rest.agent.service.AgentServiceImpl;

@RestController
@RequestMapping("api/agent")

public class AgentController {
	@Autowired
	private AgentServiceImpl agentService;
	
//	http://localhost:8082/api/agent/
	
//	http://localhost:8082/api/agent/getAllAgents
//	http://localhost:8082/api/agent/getAgentByName/{aName}
//	http://localhost:8082/api/agent/getAgentById/{aId}
//	http://localhost:8082/api/agent/addAgent
//	http://localhost:8082/api/agent/updateAgent/{aid}
//	http://localhost:8082/api/agent/deleteAgent/{aid}
	
	private ResponseEntity<?> responseEntity;
	
	@GetMapping("/getAllAgents")
	public ResponseEntity<?> getAllAgentsHandler(){
		List<Agent> allAgents = this.agentService.getAllAgents();
		responseEntity = new ResponseEntity<>(allAgents,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAgentByName/{aName}")
	public ResponseEntity<?> getAgentByNameHandler(@PathVariable String aName){
		List<Agent> uObj = this.agentService.getAgentByName(aName);
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAgentById/{aId}")
	public Agent getAgentByIdHandler(@PathVariable String aId){
		Agent uObj = this.agentService.getAgentById(aId);
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return uObj;
	}
	
	@GetMapping("/getAllAgentNames")
	public ResponseEntity<?> getAllAgentNamesHandler(){
		List<String> uObj = this.agentService.getAllAgentNames();
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/getAllAgentByEmail/{aEmail}")
	public ResponseEntity<?> getAllAgentByEmailHandler(@PathVariable String aEmail){
		System.out.println("Email Received: "+aEmail);
		Agent uObj = this.agentService.getAgentByEmail(aEmail);
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PostMapping("/addAgent")
	public ResponseEntity<?> addAgentHandler(@RequestParam("agentName") String agentName, @RequestParam("agentPassoword") String agentPassoword, @RequestParam("agentMobile") String agentMobile, @RequestParam("agentEmail") String agentEmail, @RequestParam("agentAddress") String agentAddress,
			@RequestParam("propertyId") String propertyId, @RequestParam(value="image", required = false) MultipartFile image, Model model) throws IOException{
				
		Agent property = new Agent(agentName, agentPassoword, agentMobile, agentEmail, agentAddress,
				propertyId);
		Binary imageData =ImageConversion(image);
		property.setImage(imageData);	
	    Agent id = agentService.addAgent(property);
		responseEntity = new ResponseEntity<>(id,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PutMapping("/updateAgent/{aid}")
	public ResponseEntity<?> updateAgentHandler(@RequestBody Agent uObj, @PathVariable String aid){
		System.out.println("Id recieved to update: "+aid);
		boolean uObj1 = this.agentService.UpdateAgent(uObj, aid);
		responseEntity = new ResponseEntity<>(uObj1,HttpStatus.OK);
		return responseEntity;
		
	}
	
	
	@DeleteMapping("/deleteAgent/{aid}")
	public ResponseEntity<?> deleteAgentHandler(@PathVariable String aid){
		System.out.println("Delete mapping: "+aid);
		boolean uObj1 = this.agentService.deleteAgent(aid);
		responseEntity = new ResponseEntity<>(uObj1,HttpStatus.OK);
		return responseEntity;
		
	}
	
	public Binary ImageConversion(MultipartFile image) throws IOException {
		Binary imageData = new Binary(BsonBinarySubType.BINARY, image.getBytes());
		return imageData;
		
	}
	
	

}
