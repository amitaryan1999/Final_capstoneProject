package com.consult.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consult.model.Consult;
import com.consult.services.IConsultService;


@RestController
@RequestMapping("/consult")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultController {

	@Autowired
	private IConsultService consultService;
	

//	http://localhost:8082/tour/addConsult
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addConsult")
	public ResponseEntity<?> saveConsultHandler(@RequestBody Consult consult)
	{
		
		Consult newTour = this.consultService.addCon(consult);
		responseEntity = new ResponseEntity<>(newTour,HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	@GetMapping("/getAllConsult")
	public ResponseEntity<?> getAllConsHandler()
	{
		List<Consult> allCons = this.consultService.getAllCons();
		responseEntity = new ResponseEntity<>(allCons,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getConById/{consultId}")
	public ResponseEntity<?> getConByIdHandler(@PathVariable String consultId)
	{
		Consult consult = this.consultService.getConById(consultId);
		responseEntity = new ResponseEntity<>(consult,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delConById/{consultId}")
	public ResponseEntity<?> DeleteNoteByIdHandler(@PathVariable String consultId)
	{
		boolean status = this.consultService.delCOn(consultId);
		responseEntity = new ResponseEntity<>("Consultation Details Deleted ....",HttpStatus.OK);
		return responseEntity;
	}
	
}
