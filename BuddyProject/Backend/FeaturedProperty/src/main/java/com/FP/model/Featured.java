package com.FP.model;
import java.util.ArrayList;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Featured {

//	@Id
//	private String id;
//	private List<String> property_Id;
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public List<String> getProperty_Id() {
//		return property_Id;
//	}
//	public void setProperty_Id(List<String> property_Id) {
//		this.property_Id = property_Id;
//	}
//	@Override
//	public String toString() {
//		return "Featured [id=" + id + ", property_Id=" + property_Id + "]";
//	}
//	public void addPropertyID(String newPropertyID) {
//
//        if (property_Id == null) {
//
//        	property_Id = new ArrayList<>();
//
//        }
//
//        property_Id.add(newPropertyID);
//
//    }
	
	
	@Id
//	@GeneratedValue
	private String id;
	private String property_Id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProperty_Id() {
		return property_Id;
	}
	public void setProperty_Id(String property_Id) {
		this.property_Id = property_Id;
	}
	@Override
	public String toString() {
		return "Featured [id=" + id + ", property_Id=" + property_Id + "]";
	}
	
	
}
