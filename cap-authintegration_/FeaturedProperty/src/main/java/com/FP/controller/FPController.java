package com.FP.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import com.FP.model.Featured;
import com.FP.services.IFPService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/featured")
public class FPController {
	
	@Autowired
	private IFPService FeaturedPropertyservice;
	
	private ResponseEntity<?> responseEntity;
//	http://localhost:8085/api/property/
	
//	http://localhost:8085/api/property/getAllProperty
//	http://localhost:8085/api/property/addProperty
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllFeatured")
	public ResponseEntity<?> getAllPropertyHandler()
	{
		List<Featured> allProperty = this.FeaturedPropertyservice.getAllFeaturedProperty();
		responseEntity = new ResponseEntity<>(allProperty,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getFPropertybyid/{uid}")
	public ResponseEntity<?> getPropertyByIdHandler(@PathVariable String uid)
	{
		Featured uObj = this.FeaturedPropertyservice.getFeaturedPropertyByID(uid);
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delFPropertybyid/{uid}")
	public ResponseEntity<?> DeletePropertyByIdHandler(@PathVariable String uid)
	{
		boolean status = this.FeaturedPropertyservice.deleteFeaturedProperty(uid);
		responseEntity = new ResponseEntity<>("Property Details Deleted ...."+status,HttpStatus.OK);
		return responseEntity;
	
	}
	@PostMapping("/saveuser")
	public ResponseEntity<?> addUserHandler(@RequestBody Featured nobj){
		boolean newUser = this.FeaturedPropertyservice.saveProperty(nobj);
		responseEntity = new ResponseEntity<>("User added: "+newUser, HttpStatus.CREATED);
		return responseEntity;
	}
	

}
