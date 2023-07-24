package com.ap.Services;

import java.util.List;

import com.ap.Execption.AppointDetailsAlreadyExists;
import com.ap.Execption.AppointDetailsNotFound;
import com.ap.model.apUser;
public interface IApService {
	
	
public apUser addAppoint (apUser sAppoint) throws AppointDetailsAlreadyExists;
	
	public apUser updateAppoint (apUser sAppoint,int AppointmentId ) throws AppointDetailsNotFound;
	
	public apUser getAppointById(int AppointmentId) throws AppointDetailsNotFound;
	
	public List<apUser> getAllAppoint() ;
	
	public boolean delAppoint(int AppointmentId) throws AppointDetailsNotFound;
	

}

