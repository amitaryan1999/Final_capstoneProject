package com.rest.model;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Document(collection="userProperty")
public class UserProperty {
	@Id
	private String property_id;
	
	private String property_name;
	private String desc;
	private String category;
	private int bedroom;
	private int bathroom;
	private boolean parking;
	private double area;
	private String year_build;
	private String location;
	private String agentName;
	private boolean buy;
	private boolean rent;
	private double buyPrice;
	private double rentPrice;
	private boolean balcony;
	private boolean deck;
	private boolean cableTV;
	private boolean pool;
	private String video;
	private Binary image;
	
	
	
	
	public String getProperty_id() {
		return property_id;
	}
	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBedroom() {
		return bedroom;
	}
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getYear_build() {
		return year_build;
	}
	public void setYear_build(String year_build) {
		this.year_build = year_build;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public boolean isBalcony() {
		return balcony;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	public boolean isDeck() {
		return deck;
	}
	public void setDeck(boolean deck) {
		this.deck = deck;
	}
	public boolean isCableTV() {
		return cableTV;
	}
	public void setCableTV(boolean cableTV) {
		this.cableTV = cableTV;
	}
	public boolean isPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public Binary getImages() {
		return image;
	}
	public void setImages(Binary image) {
	this.image=image;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "UserProperty [property_id=" + property_id + ", property_name=" + property_name + ", desc=" + desc
				+ ", category=" + category + ", bedroom=" + bedroom + ", bathroom=" + bathroom + ", parking=" + parking
				+ ", area=" + area + ", year_build=" + year_build + ", location=" + location
				+ ", agentName=" + agentName + ", buy=" + buy + ", rent=" + rent + ", buyPrice=" + buyPrice
				+ ", rentPrice=" + rentPrice + ", balcony=" + balcony + ", deck=" + deck + ", cableTV=" + cableTV
				+ ", pool=" + pool + ", video=" + video + ", image=" + image + ", getProperty_id()="
				+ getProperty_id() + ", getProperty_name()=" + getProperty_name() + ", getDesc()=" + getDesc()
				+ ", getCategory()=" + getCategory() + ", getBedroom()=" + getBedroom() + ", getBathroom()="
				+ getBathroom() + ", isParking()=" + isParking() + ", getArea()=" + getArea() + ", getYear_build()="
				+ getYear_build() + ", getLocation()=" + getLocation()
				+ ", getAgentName()=" + getAgentName() + ", isBuy()=" + isBuy() + ", isRent()=" + isRent()
				+ ", getBuyPrice()=" + getBuyPrice() + ", getRentPrice()=" + getRentPrice() + ", isBalcony()="
				+ isBalcony() + ", isDeck()=" + isDeck() + ", isCableTV()=" + isCableTV() + ", isPool()=" + isPool()
				+ ", getVideo()=" + getVideo() + ", getImages()=" + getImages() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	public UserProperty() {
		super();
	}
	public UserProperty(Binary images) {
		super();
		this.image = images;
	}
	public UserProperty(String property_name, String desc, String category, int bedroom, int bathroom, boolean parking,
			double area, String year_build, String location, String agentName, boolean buy, boolean rent,
			double buyPrice, double rentPrice, boolean balcony, boolean deck, boolean cableTV, boolean pool,
			String video) {
		super();
		this.property_name = property_name;
		this.desc = desc;
		this.category = category;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.parking = parking;
		this.area = area;
		this.year_build = year_build;
		this.location = location;
		this.agentName = agentName;
		this.buy = buy;
		this.rent = rent;
		this.buyPrice = buyPrice;
		this.rentPrice = rentPrice;
		this.balcony = balcony;
		this.deck = deck;
		this.cableTV = cableTV;
		this.pool = pool;
		this.video = video;
	}	

	
	
}


