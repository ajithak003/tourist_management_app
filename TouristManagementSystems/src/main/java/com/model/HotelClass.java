package com.model;

import java.util.Objects;

public class HotelClass {
	
	private int hotelId;
	private String location;
	private String hotelName;
	private String roomType;
	private float price;
	public HotelClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HotelClass(int hotelId, String location, String hotelName, String roomType, float price) {
		super();
		this.hotelId = hotelId;
		this.location = location;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.price = price;
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "HotelClass [hotelId=" + hotelId + ", location=" + location + ", hotelName=" + hotelName + ", roomType="
				+ roomType + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(hotelId, hotelName, location, price, roomType);
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
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(roomType, other.roomType);
	}
	
	
	
	

}
