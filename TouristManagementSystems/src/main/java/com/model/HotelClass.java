package com.model;

import java.util.Objects;

public class HotelClass {
	
	private int hotelId;
	private String location;
	private String hotelName;
	private double midRangePrice;
	private double premiumPrice;
	public HotelClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HotelClass(int hotelId, String location, String hotelName, double midRangePrice, double premiumPrice) {
		super();
		this.hotelId = hotelId;
		this.location = location;
		this.hotelName = hotelName;
		this.midRangePrice = midRangePrice;
		this.premiumPrice = premiumPrice;
	}
	public HotelClass(String location, String hotelName, double midRangePrice, double premiumPrice) {
		super();
		this.location = location;
		this.hotelName = hotelName;
		this.midRangePrice = midRangePrice;
		this.premiumPrice = premiumPrice;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getMidRangePrice() {
		return midRangePrice;
	}
	public void setMidRangePrice(double midRangePrice) {
		this.midRangePrice = midRangePrice;
	}
	public double getPremiumPrice() {
		return premiumPrice;
	}
	public void setPremiumPrice(double primiumPrice) {
		this.premiumPrice = primiumPrice;
	}
	@Override
	public String toString() {
		return "HotelClass \nhotelId=" + hotelId + "\n location=" + location + "\n hotelName=" + hotelName
				+ "\n midRangePrice=" + midRangePrice + "\n premiumPrice=" + premiumPrice ;
	}
	public String usertoString(HotelClass hotelClass) {
		return "HotelClass  \n location=" + hotelClass.location + "\n hotelName=" + hotelClass.hotelName
				+ "\n midRangePrice=" + hotelClass.midRangePrice + "\n premiumPrice=" + hotelClass.premiumPrice;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hotelId, hotelName, location, midRangePrice, premiumPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelClass other = (HotelClass) obj;
		return hotelId == other.hotelId && Objects.equals(hotelName, other.hotelName)
				&& Objects.equals(location, other.location)
				&& Double.doubleToLongBits(midRangePrice) == Double.doubleToLongBits(other.midRangePrice)
				&& Double.doubleToLongBits(premiumPrice) == Double.doubleToLongBits(other.premiumPrice);
	}
	
	
	

}
