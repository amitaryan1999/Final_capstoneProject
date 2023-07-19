package com.tour.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.model.ScheduleTour;

import com.tour.repository.IScheduleTourRepository;

@Service
public class ScheduleTourImpl implements IScheduleTourService {

	@Autowired
	private IScheduleTourRepository schedulerepository;
	
	@Override
	public ScheduleTour addTour(ScheduleTour sTour) {
		int count=0;
		String tourDate = sTour.getDate();
        String tourSlots = sTour.getSlots();
//        String scheduleId = sTour.getScheduleId();
        

        // Check if the date and slots are available
        if (isSlotsAvailable(tourSlots,tourDate)) {
            return schedulerepository.save(sTour);
//            count++;
        } else {
            System.out.println("Date or slots are not available for booking!");
            return null;
        }
	}

	@Override
	public ScheduleTour updateTour(ScheduleTour sTour, int scheduleId) {
//		get the user details which to be updated by passing the user id
		Optional<ScheduleTour> tourOptional = this.schedulerepository.findById(scheduleId);

    	ScheduleTour stour = null;
    	ScheduleTour updatedData = null;
    	
//    	Checking whether user id exists or not
        if(tourOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	stour = tourOptional.get();
 
//        	setting the updated value to setter method by taking from user through getter
           	stour.setcName(sTour.getcName());
        	stour.setDate(sTour.getDate());
        	stour.setSlots(sTour.getSlots());
        	stour.setMobNo(sTour.getMobNo());
 
//        	saving the final updated value to db
        	updatedData = this.schedulerepository.save(stour);
        	
        }

//        returning the updated value to user
        return updatedData;
	}

	@Override
	public ScheduleTour getTourById(int scheduleId) {
		Optional<ScheduleTour> tourOptional = this.schedulerepository.findById(scheduleId);

    	ScheduleTour sTour = null;
    	
//    	Checking whether user id exists or not
        if(tourOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	sTour = tourOptional.get();
        }
        else
        {
        	System.out.println("ScheduleTour does not exists");
        }

        return sTour;
	}

	@Override
	public List<ScheduleTour> getAllTours() {
		
		return this.schedulerepository.findAll();
	}

	@Override
	public boolean delTour(int scheduleId) {
		Optional<ScheduleTour> tourOptional = this.schedulerepository.findById(scheduleId);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(tourOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.schedulerepository.delete(tourOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("Tour details does not exits for delete ..");
        }
        return status;
	}
	
	private boolean isSlotsAvailable(String tourSlots,String tourDate) {
		Optional<ScheduleTour> tourOptional = schedulerepository.findByDate(tourDate,tourSlots);
		boolean status=true;
		if(tourOptional.isPresent()) {
			System.out.println("Slot Already Booked");
			status=false;
		}
		
			return status;
    }
}