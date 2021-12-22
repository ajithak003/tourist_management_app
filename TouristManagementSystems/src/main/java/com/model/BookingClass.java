package com.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BookingClass {
	
	private int bookingId;
	private int userId;
	private int packageIid;
	private int flightNo;
	private int hotelId;
	private int noOfPerson;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalPrice;
	private String status;
	private LocalDateTime bookingDate;
	private String flightClass;
	private String hotelRoomType;
	private String daysPlan;
	
	
	public BookingClass(int bookingId, int userId, int packageIid, int flightNo, int hotelId, int noOfPerson, LocalDate startDate, LocalDate endDate, double totalPrice, String status, LocalDateTime bookingDate,String flightClass,String hotelRoomType, String daysPlan) {
		super();
		// TODO Auto-generated constructor stub
		this.bookingId = bookingId;
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.hotelId = hotelId;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.bookingDate = bookingDate;
		this.flightClass = flightClass;
		this.hotelRoomType = hotelRoomType;
		this.daysPlan = daysPlan;
		
	}


	public BookingClass(int userId, int packageIid, int flightNo, int hotelId, int noOfPerson, LocalDate startDate,
			LocalDate endDate, double totalPrice,String flightClass,String hotelRoomType, String daysPlan) {
		super();
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.hotelId = hotelId;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.flightClass = flightClass;
		this.hotelRoomType = hotelRoomType;
		this.daysPlan = daysPlan;
	}

	
	
	public String getDaysPlan() {
		return daysPlan;
	}


	public void setDaysPlan(String daysPlan) {
		this.daysPlan = daysPlan;
	}


	public String getFlightClass() {
		return flightClass;
	}


	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}


	public String getHotelRoomType() {
		return hotelRoomType;
	}


	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPackageIid() {
		return packageIid;
	}


	public void setPackageIid(int packageIid) {
		this.packageIid = packageIid;
	}


	public int getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public int getNoOfPerson() {
		return noOfPerson;
	}


	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDateTime getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}


	
	
	

	

	@Override
	public String toString() {
		return "BookingClass \n\n noOfPerson=" + noOfPerson + "\n startDate=" + startDate + "\n endDate=" + endDate
				+ "\n totalPrice=" + totalPrice + "\n status=" + status + "\n bookingDate=" + bookingDate
				+ "\n flightClass=" + flightClass + "\n hotelRoomType=" + hotelRoomType + "\n daysPlan=" + daysPlan ;
	}


	public String toStringbook(UserClass user, PackageModeClass packages, FlightClass flight, HotelClass hotel) {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		
		return "\n Booking Details \n \n \n Customer Name :  "+user.getName()+"\n \n User Email :  "+user.getEmail()+
				"\n\n\n Flight Details : \n\n Flight Name :  "+flight.getFlightName()+"\n\n Source Place :  "+flight.getDepature()+"\n\n destination Place :  "+flight.getDestination()+
				"\n\n Depature Date & Time : "+flight.getDepatureDateTime().format(dateTimeFormat)+"\n\n Arrival Date & Time :  "+flight.getArrivalDateTime().format(dateTimeFormat)+"\n\n Flight ticket Class :  "+flightClass+
				"\n\n Flight Status :  "+flight.getStatus()+"\n\n\n Hotel Details : \n\n Hotel Name :  "+hotel.getHotelName()+"\n\n Hotel Location : "+hotel.getLocation()+
				"\n\n Hotel Room Type :  "+hotelRoomType+"\n\n\n Package Details :\n\n Booking Date :  "+bookingDate.format(dateTimeFormat)+"\n\n Tourist Location :  "+packages.getName()+
				"\n\n Tour Plan Days :  "+daysPlan+"\n\n Tour Start Date : "+startDate.format(dateFormat)+"\n\n Tour End Day :  "+endDate.format(dateFormat)+"\n\n Number Of Person :  "+noOfPerson+
				"\n\n Package Total Price :  "+totalPrice+"\n\n Package Status :  "+status;
		
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, endDate, flightNo, hotelId, noOfPerson, packageIid, startDate,
				status, totalPrice, userId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingClass other = (BookingClass) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(endDate, other.endDate) && flightNo == other.flightNo && hotelId == other.hotelId
				&& noOfPerson == other.noOfPerson && packageIid == other.packageIid
				&& Objects.equals(startDate, other.startDate) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	
	
     
	
	


	
	

}
