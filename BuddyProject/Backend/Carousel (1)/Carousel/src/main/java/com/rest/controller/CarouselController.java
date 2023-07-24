package com.rest.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.bson.types.Binary;
import org.bson.BsonBinarySubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import com.rest.model.Carousel;
import com.rest.service.ICarousalService;



@RestController
@RequestMapping("/carousel")
public class CarouselController {
	@Autowired
	private ICarousalService carouselService;
	
	private ResponseEntity<?> responseEntity;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/photos/add")
	public Carousel addPhoto(@RequestBody Carousel cObj) 
	  throws IOException {
		System.out.println(cObj);
		Carousel savedCarousel = carouselService.addPhoto(cObj.getPropertyID());
	      
	    return savedCarousel;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/photos/getAllID")
	public List<Carousel> getPhoto() {
	    List<Carousel> photo = carouselService.getPropertyID();
	    return photo;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/photos/getAllPhotos")
	public ResponseEntity<?> getAllPhoto() {
	    List<Carousel> photo = this.carouselService.getAllPhotos();
	    responseEntity = new ResponseEntity<>(photo,HttpStatus.OK);
	    return responseEntity;
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/photos/delete/{cid}")
	public ResponseEntity<?> deleteHandler(@PathVariable String cid){
		System.out.println(cid);
		String msg = this.carouselService.deleteCarousel(cid);
		responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return responseEntity;
	}
	
	
}
