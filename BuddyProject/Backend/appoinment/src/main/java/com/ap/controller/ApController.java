package com.ap.controller;

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

import com.ap.Execption.AppointDetailsAlreadyExists;
import com.ap.Execption.AppointDetailsNotFound;
import com.ap.Services.IApService;
import com.ap.model.apUser;


@RestController
@RequestMapping("/appoint")
@CrossOrigin(origins = "http://localhost:4200")
public class ApController {
	
	@Autowired
	IApService iapservices;

	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addAppoint")
	public ResponseEntity<?> saveScheduleAppointHandler(@RequestBody apUser sAppoint) throws AppointDetailsAlreadyExists
	{
		
		apUser newAppoint = this.iapservices.addAppoint(sAppoint);
		if (newAppoint != null) {
            return ResponseEntity.ok("Appointment booked successfully");
        } else {
            return ResponseEntity.badRequest().body("Doctor or slots are not available for booking");
        }
	}
	
	@PutMapping("/updateAppoint/{AppointmentId}")
	public ResponseEntity<?> updateAppointHandler(@RequestBody apUser sAppoint, @PathVariable int AppointmentId) throws AppointDetailsNotFound 
	{
		apUser newAssign = this.iapservices.updateAppoint(sAppoint,AppointmentId);
		responseEntity = new ResponseEntity<>(newAssign,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllAppoint")
	public ResponseEntity<?> getAllAppointHandler()
	{
		List<apUser> allAppoint = this.iapservices.getAllAppoint();
		responseEntity = new ResponseEntity<>(allAppoint,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAppointById/{AppointmentId}")
	public ResponseEntity<?> getTourByIdHandler(@PathVariable int AppointmentId) throws AppointDetailsNotFound
	{
		apUser sTour = this.iapservices.getAppointById(AppointmentId);
		responseEntity = new ResponseEntity<>(sTour,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delAppointById/{AppointmentId}")
	public ResponseEntity<?> DeleteNoteByIdHandler(@PathVariable int AppointmentId) throws AppointDetailsNotFound
	{
		boolean status = this.iapservices.delAppoint(AppointmentId);
		responseEntity = new ResponseEntity<>("ScheduleAppointment Details Deleted ....",HttpStatus.OK);
		return responseEntity;
	}
}
