package com.rest.model;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "photos")
public class Carousel {
	@Id
    private String id;
    private List<String> propertyID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(List<String> propertyID) {
		this.propertyID = propertyID;
	}
	@Override
	public String toString() {
		return "Carousel [id=" + id + ", propertyID=" + propertyID + "]";
	}
	public Carousel() {
		super();
	}
	public Carousel(List<String> propertyID) {
		super();
		this.propertyID = propertyID;
	}
	
	public void addPropertyID(String newPropertyID) {
        if (propertyID == null) {
            propertyID = new ArrayList<>();
        }
        propertyID.add(newPropertyID);
    }
    
}
