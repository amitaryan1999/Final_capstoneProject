package com.tour.service;



import java.util.List;

import com.tour.exceptions.TourDetailsAlreadyExists;
import com.tour.exceptions.TourDetailsNotFound;
import com.tour.model.ScheduleTour;

public interface IScheduleTourService {

	
	public ScheduleTour addTour (ScheduleTour sTour) throws TourDetailsAlreadyExists;
	
	public ScheduleTour updateTour (ScheduleTour sTour,int scheduleId ) throws TourDetailsNotFound;
	
	public ScheduleTour getTourById(int scheduleId) throws TourDetailsNotFound;
	
	public List<ScheduleTour> getAllTours() ;
	
	public boolean delTour(int scheduleId) throws TourDetailsNotFound;
	
	
}

//public boolean booked(LocalDate date, List<LocalTime> slots);

//public User saveUser(User uobj);
//public User updateUser(User uobj,int uid);
//public User getUserById(int uid);
//public List<User> getAllUsers();
//public boolean delUser(int uid);