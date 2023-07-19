package com.consult.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.consult.model.Consult;
import com.consult.repository.IConsultRepository;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ConsultServiceImpl implements IConsultService {

	@Autowired
	public IConsultRepository consultRepository;
	
	
	@Override
	public Consult addCon(Consult consult) {
		Consult addConsult = this.consultRepository.insert(consult);
		return addConsult;
	}

	@Override
	public Consult updateCon(Consult consult, String consultId) {
//		get the user details which to be updated by passing the user id
		Optional<Consult> consOptional = this.consultRepository.findById(consultId);

    	Consult cons = null;
    	Consult updatedData = null;
    	
//    	Checking whether user id exists or not
        if(consOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	cons = consOptional.get();
 
//        	setting the updated value to setter method by taking from user through getter
           	cons.setFname(consult.getFname());
        	cons.setLname(consult.getLname());
        	cons.setEmail(consult.getEmail());
        	cons.setMessage(consult.getMessage());
 
//        	saving the final updated value to db
        	updatedData = this.consultRepository.save(cons);
        	
	}
        return updatedData;
  }

	@Override
	public Consult getConById(String consultId) {
		Optional<Consult> conOptional = this.consultRepository.findById(consultId);

    	Consult cons = null;
    	
//    	Checking whether user id exists or not
        if(conOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	cons = conOptional.get();
        }
        else
        {
        	System.out.println("Consult does not exists");
        }

        return cons;
	}

	@Override
	public List<Consult> getAllCons() {
		return this.consultRepository.findAll();
	}

	@Override
	public boolean delCOn(String consultId) {
		Optional<Consult> consOptional = this.consultRepository.findById(consultId);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(consOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.consultRepository.delete(consOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("Consultation details does not exits for delete ..");
        }
        return status;
	}
	
}
