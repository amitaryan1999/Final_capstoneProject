package com.FP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FP.Repository.IFPRepository;
import com.FP.model.Featured;

@Service
public class IFPServiceImp implements IFPService {
	
	@Autowired
	private IFPRepository featuredPropertyRepo;

	@Override
	public Featured getFeaturedPropertyByID(String id) {
		Optional<Featured> propertyOptional = this.featuredPropertyRepo.findById(id);

		Featured nObj = null;
    	
//    	Checking whether user id exists or not
        if(propertyOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	nObj = propertyOptional.get();
        }
        else
        {
        	System.out.println("Featured Property does not exists");
        }

        return nObj;
	}

	@Override
	public List<Featured> getAllFeaturedProperty() {
		// TODO Auto-generated method stub
		return this.featuredPropertyRepo.findAll();
	}

	@Override
	public boolean deleteFeaturedProperty(String cid) {
		// TODO Auto-generated method stub
		Optional<Featured> propertyOptional = this.featuredPropertyRepo.findById(cid);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(propertyOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.featuredPropertyRepo.delete(propertyOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("Featured Property details does not exits for delete ..");
        }
        return status;
	}

	@Override
	public List<Featured> getPropertyID() {
		// TODO Auto-generated method stub
		List<Featured> carousel = this.featuredPropertyRepo.findAll();

        return carousel;
	}

	@Override
	public boolean saveProperty(Featured nobj) {
		 this.featuredPropertyRepo.save(nobj);
			return true;
		

       
	}
}

