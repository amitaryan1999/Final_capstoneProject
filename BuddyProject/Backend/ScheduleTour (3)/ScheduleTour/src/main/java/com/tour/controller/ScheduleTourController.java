package com.tour.controller;

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

import com.tour.exceptions.TourDetailsAlreadyExists;
import com.tour.exceptions.TourDetailsNotFound;
import com.tour.model.ScheduleTour;
import com.tour.service.IScheduleTourService;

@RestController
@RequestMapping("/tour")
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleTourController {

	@Autowired
	private IScheduleTourService scheduleService;
	

//	http://localhost:8082/tour/addTour
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addTour")
	public ResponseEntity<?> saveScheduleTourHandler(@RequestBody ScheduleTour sTour) throws TourDetailsAlreadyExists
	{
		
		ScheduleTour newTour = this.scheduleService.addTour(sTour);
		if (newTour != null) {
            return ResponseEntity.ok("Tour booked successfully");
        } else {
            return ResponseEntity.badRequest().body("Date or slots are not available for booking");
        }
	}
	
	@PutMapping("/updateTour/{scheduleId}")
	public ResponseEntity<?> updateTourHandler(@RequestBody ScheduleTour sTour, @PathVariable int scheduleId) throws TourDetailsNotFound 
	{
		ScheduleTour newTour = this.scheduleService.updateTour(sTour,scheduleId);
		responseEntity = new ResponseEntity<>(newTour,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllTour")
	public ResponseEntity<?> getAllTourHandler()
	{
		List<ScheduleTour> allTour = this.scheduleService.getAllTours();
		responseEntity = new ResponseEntity<>(allTour,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getTourById/{scheduleId}")
	public ResponseEntity<?> getTourByIdHandler(@PathVariable int scheduleId) throws TourDetailsNotFound
	{
		ScheduleTour sTour = this.scheduleService.getTourById(scheduleId);
		responseEntity = new ResponseEntity<>(sTour,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delTourById/{scheduleId}")
	public ResponseEntity<?> DeleteNoteByIdHandler(@PathVariable int scheduleId) throws TourDetailsNotFound
	{
		boolean status = this.scheduleService.delTour(scheduleId);
		responseEntity = new ResponseEntity<>("ScheduleTour Details Deleted ....",HttpStatus.OK);
		return responseEntity;
	}
	
	
}
