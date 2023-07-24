package com.ap.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.Execption.AppointDetailsAlreadyExists;
import com.ap.Execption.AppointDetailsNotFound;
import com.ap.model.apUser;
import com.ap.repository.IaprRepo;

@Service
public class IApServicesImp implements IApService {

	@Autowired
	private IaprRepo appointrepo;

	@Override
	public apUser addAppoint(apUser sAppoint) throws AppointDetailsAlreadyExists {
		int count=0;
		String appointDoctor = sAppoint.getDoctor();
        String appointSlots = sAppoint.getSlots();
//        String scheduleId = sTour.getScheduleId();
        

        // Check if the date and slots are available
        if (isSlotsAvailable(appointSlots,appointDoctor)) {
            return appointrepo.save(sAppoint);
//            count++;
        } else {
            System.out.println("Date or slots are not available for booking!");
            return null;
        }
	}

	@Override
	public apUser updateAppoint(apUser sAppoint, int AppointmentId) throws AppointDetailsNotFound {
		// TODO Auto-generated method stub
		Optional<apUser> appointOptional = this.appointrepo.findById(AppointmentId);

		apUser sappoint = null;
		apUser updatedData = null;
    	
//    	Checking whether user id exists or not
        if(appointOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	sappoint = appointOptional.get();
 
//        	setting the updated value to setter method by taking from user through getter
        	sappoint.setcName(sappoint.getcName());
        	sappoint.setDate(sappoint.getDate());
        	sappoint.setSlots(sappoint.getSlots());
        	sappoint.setMobNo(sappoint.getMobNo());
 
//        	saving the final updated value to db
        	updatedData = this.appointrepo.save(sappoint);
        	
        }

//        returning the updated value to user
        return updatedData;
	}

	@Override
	public apUser getAppointById(int AppointmentId) throws AppointDetailsNotFound {
		// TODO Auto-generated method stub
		Optional<apUser> appointOptional = this.appointrepo.findById(AppointmentId);

		apUser sappoint = null;
    	
//    	Checking whether user id exists or not
        if(appointOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	sappoint = appointOptional.get();
        }
        else
        {
        	System.out.println("ScheduleAppoint does not exists");
        }

        return sappoint;
	}

	@Override
	public List<apUser> getAllAppoint() {
		// TODO Auto-generated method stub
		return this.appointrepo.findAll();
	}

	@Override
	public boolean delAppoint(int AppointmentId) throws AppointDetailsNotFound {
		// TODO Auto-generated method stub
		Optional<apUser> tourOptional = this.appointrepo.findById(AppointmentId);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(tourOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.appointrepo.delete(tourOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("Appointment details does not exits for delete ..");
        }
        return status;
	}
	
	private boolean isSlotsAvailable(String appointSlots,String doctor) {
		Optional<apUser> appointOptional = appointrepo.findByDate(doctor,appointSlots);
//		boolean status=true;
		if(appointOptional.isPresent()) {
			System.out.println("Slot Already Booked");
			return false;
		}
		
			return true;
    }

}
