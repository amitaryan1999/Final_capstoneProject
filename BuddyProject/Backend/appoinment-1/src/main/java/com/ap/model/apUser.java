package com.ap.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class apUser {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String AppointmentId;
	public String cName;
	public String mobNo;
	public String date;
	public String slots;
	public String email;
	public String getAppointmentId() {
		return AppointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		AppointmentId = appointmentId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "apUser [AppointmentId=" + AppointmentId + ", cName=" + cName + ", mobNo=" + mobNo + ", date=" + date
				+ ", slots=" + slots + ", email=" + email + "]";
	}
	
	
}
