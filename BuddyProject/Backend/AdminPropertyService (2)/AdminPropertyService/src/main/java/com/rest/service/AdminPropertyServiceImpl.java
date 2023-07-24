package com.rest.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rest.model.UserProperty;
import com.rest.repository.IAdminProperty;
import java.util.ArrayList;

@Service
public class AdminPropertyServiceImpl implements IAdminPropertyService {
	@Autowired
	private IAdminProperty adminPropertyRepo;

	@Override
	public UserProperty updateProperty(UserProperty nobj, String nid) {
		Optional<UserProperty> propertyOptional = this.adminPropertyRepo.findById(nid);

		UserProperty nObj = null;
		UserProperty updatedData = null;
    	
//    	Checking whether user id exists or not
        if(propertyOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	nObj = propertyOptional.get();
 
//        	setting the updated value to setter method by taking from user through getter
           	
        	if(nobj.getProperty_name()!=null) {
        		nObj.setProperty_name(nobj.getProperty_name());
        	}
        	if(nobj.getAgentName()!=null) {
        		nObj.setAgentName(nobj.getAgentName());
        	}
        	if(nobj.getArea()!= 0.0) {
        		nObj.setArea(nobj.getArea());
        	}
        	if(nobj.getBathroom() != 0) {
        		nObj.setBathroom(nobj.getBathroom());
        	}
        	if(nobj.getBedroom() !=0) {
        	nObj.setBedroom(nobj.getBedroom());
        	}
        	nObj.setBuy(nobj.isBuy());
        	
        	if(nobj.getCategory()!=null) {
        	nObj.setCategory(nobj.getCategory());
        	}
        	if(nobj.getDesc() !=null) {
        	nObj.setDesc(nobj.getDesc());
        	}
        	if(nobj.getLocation()!=null) {
        	nObj.setLocation(nobj.getLocation());
        	}
        	nObj.setParking(nobj.isParking());
        	if(nobj.getProperty_name()!=null) {
        	nObj.setProperty_name(nobj.getProperty_name());
        	}
        	nObj.setRent(nobj.isRent());
        	if(nobj.getYear_build()!=null) {
        	nObj.setYear_build(nobj.getYear_build());
        	}
        	if(nobj.getImages() != null) {
        		nObj.setImages(nobj.getImages());
        	}
        	if(nobj.getVideo()!=null) {
        		nObj.setVideo(nobj.getVideo());
        	}
        	if(nobj.getBuyPrice()!=0.0) {
        		nObj.setBuyPrice(nobj.getBuyPrice());
        	}
        	if(nobj.getRentPrice()!=0.0) {
        		nObj.setRentPrice(nobj.getRentPrice());
        	}
        	nObj.setBalcony(nobj.isBalcony());
        	nObj.setCableTV(nobj.isCableTV());
        	nObj.setDeck(nobj.isDeck());
        	nObj.setPool(nobj.isPool());
        	
 
//        	saving the final updated value to db
        	updatedData = this.adminPropertyRepo.save(nObj);	
        }
        else
        {
        	System.out.println("Property Not Found");
        }
//        returning the updated value to user
        return updatedData;
	}

	@Override
	public UserProperty getPropertyById(String nid) {
		Optional<UserProperty> propertyOptional = this.adminPropertyRepo.findById(nid);

		UserProperty nObj = null;
    	
//    	Checking whether user id exists or not
        if(propertyOptional.isPresent())
        {
        	System.out.println("Record Exists");
        	
//        	Extracting the user details as user object from optional
        	nObj = propertyOptional.get();
        }
        else
        {
        	System.out.println("Property does not exists");
        }
        System.out.println(nObj);
        return nObj;
	}

	@Override
	public List<UserProperty> getAllProperty() {
		// TODO Auto-generated method stub
		return this.adminPropertyRepo.findAll();
	}

	@Override
	public boolean delProperty(String nid) {
		Optional<UserProperty> propertyOptional = this.adminPropertyRepo.findById(nid);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(propertyOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.adminPropertyRepo.delete(propertyOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("Property details does not exits for delete ..");
        }
        return status;
	}

	@Override
	public UserProperty saveProperty(UserProperty uObj) throws IOException {
	    UserProperty photo = new UserProperty(uObj.getProperty_name(), uObj.getDesc(), uObj.getCategory(), uObj.getBedroom(), uObj.getBathroom(), uObj.isParking(), uObj.getArea(), uObj.getYear_build(), uObj.getLocation(), uObj.getAgentName(), uObj.isBuy(), uObj.isRent(), uObj.getBuyPrice(), uObj.getRentPrice(), uObj.isBalcony(), uObj.isDeck(), uObj.isCableTV(), uObj.isPool(), uObj.getVideo());

	    System.out.println(uObj.getImages());
	        byte[] imageData = uObj.getImages().getData();
	    photo.setImages(new org.bson.types.Binary(imageData));

	    photo = this.adminPropertyRepo.save(photo);
	    return uObj;
	}



	 @Override
	    public List<UserProperty> getPropertiesByAgentName(String agentName) {
	        return this.adminPropertyRepo.findByAgentName(agentName);
	    }

}
