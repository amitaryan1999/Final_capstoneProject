package com.rest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.bson.types.Binary;
import org.bson.BsonBinarySubType;
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
import java.util.ArrayList;
import com.rest.model.UserProperty;
import com.rest.repository.IAdminProperty;
import com.rest.service.IAdminPropertyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminPropertyService AdminPropertyservice;

	@Autowired
	private IAdminProperty adminRepo;
	private ResponseEntity<?> responseEntity;
	// http://localhost:8085/api/property/

	// http://localhost:8085/api/property/getAllProperty
	// http://localhost:8085/api/property/addProperty

	@PostMapping("/addProperty")
	public ResponseEntity<?> savePropertyHandler(@RequestParam("property_name") String property_name,
			@RequestParam("desc") String desc, @RequestParam("category") String category,
			@RequestParam("bedroom") int bedroom,
			@RequestParam("bathroom") int bathroom, @RequestParam("parking") boolean parking,
			@RequestParam("area") int area, @RequestParam("year_build") String year_build,
			@RequestParam("location") String location,
			@RequestParam("agentName") String agentName, @RequestParam("buy") boolean buy,
			@RequestParam("rent") boolean rent, @RequestParam("buyPrice") double buyPrice,
			@RequestParam("rentPrice") double rentPrice, @RequestParam("balcony") boolean balcony,
			@RequestParam("deck") boolean deck, @RequestParam("cableTV") boolean cableTV,
			@RequestParam("pool") boolean pool, @RequestParam("video") String video,
			@RequestParam(value = "image") MultipartFile image, Model model) throws IOException {

		UserProperty property = new UserProperty(property_name, desc, category, bedroom, bathroom, parking,
				area, year_build, location, agentName, buy, rent,
				buyPrice, rentPrice, balcony, deck, cableTV, pool, video);
		Binary imageData = ImageConversion(image); // Create a Binary object using your binary data type

		property.setImages(imageData);
		UserProperty id = AdminPropertyservice.saveProperty(property);

		responseEntity = new ResponseEntity<>(id, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/updateProperty/{uid}")
	public ResponseEntity<?> updatePropertyHandler(@RequestParam("property_name") String property_name,
			@RequestParam("desc") String desc, @RequestParam("category") String category,
			@RequestParam("bedroom") int bedroom,
			@RequestParam("bathroom") int bathroom, @RequestParam("parking") boolean parking,
			@RequestParam("area") int area, @RequestParam("year_build") String year_build,
			@RequestParam("location") String location,
			@RequestParam("agentName") String agentName, @RequestParam("buy") boolean buy,
			@RequestParam("rent") boolean rent, @RequestParam("buyPrice") double buyPrice,
			@RequestParam("rentPrice") double rentPrice, @RequestParam("balcony") boolean balcony,
			@RequestParam("deck") boolean deck, @RequestParam("cableTV") boolean cableTV,
			@RequestParam("pool") boolean pool, @RequestParam("video") String video,
			@RequestParam(value = "image", required = false) MultipartFile image, @PathVariable String uid, Model model)
			throws IOException {
		UserProperty property = new UserProperty(property_name, desc, category, bedroom, bathroom, parking,
				area, year_build, location, agentName, buy, rent,
				buyPrice, rentPrice, balcony, deck, cableTV, pool, video);
		if (image != null) {
			Binary imageData = ImageConversion(image);
			property.setImages(imageData);
		}
		UserProperty newProperty = this.AdminPropertyservice.updateProperty(property, uid);
		responseEntity = new ResponseEntity<>(newProperty, HttpStatus.CREATED);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllProperty")
	public ResponseEntity<?> getAllPropertyHandler() {
		List<UserProperty> allProperty = this.AdminPropertyservice.getAllProperty();
		responseEntity = new ResponseEntity<>(allProperty, HttpStatus.OK);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPropertybyid/{uid}")
	public ResponseEntity<?> getPropertyByIdHandler(@PathVariable String uid) {
		UserProperty uObj = this.AdminPropertyservice.getPropertyById(uid);
		responseEntity = new ResponseEntity<>(uObj, HttpStatus.OK);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delPropertybyid/{uid}")
	public ResponseEntity<?> DeletePropertyByIdHandler(@PathVariable String uid) {
		boolean status = this.AdminPropertyservice.delProperty(uid);
		responseEntity = new ResponseEntity<>("Property Details Deleted ...." + status, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/getPropertiesByAgentName/{agentName}")
	public ResponseEntity<?> getPropertiesByAgentNameHandler(@PathVariable String agentName) {
		System.out.println(agentName);
		List<UserProperty> properties = this.AdminPropertyservice.getPropertiesByAgentName(agentName);
		System.out.println(properties);
		responseEntity = new ResponseEntity<>(properties, HttpStatus.OK);
		return responseEntity;
	}

	public Binary ImageConversion(MultipartFile image) throws IOException {
		Binary imageData = new Binary(BsonBinarySubType.BINARY, image.getBytes());
		return imageData;

	}
}
