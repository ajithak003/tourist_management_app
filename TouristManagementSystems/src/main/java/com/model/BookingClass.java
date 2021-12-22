package com.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	
	public BookingClass() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookingClass(int bookingId, int userId, int packageIid, int flightNo, int hotelId, int noOfPerson,
			LocalDate startDate, LocalDate endDate, double totalPrice, String status, LocalDateTime bookingDate) {
		super();
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
	}


	public BookingClass(int userId, int packageIid, int flightNo, int hotelId, int noOfPerson, LocalDate startDate,
			LocalDate endDate, double totalPrice) {
		super();
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.hotelId = hotelId;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
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
		return "BookingClass [bookingId=" + bookingId + ", userId=" + userId + ", packageIid=" + packageIid
				+ ", flightNo=" + flightNo + ", hotelId=" + hotelId + ", noOfPerson=" + noOfPerson + ", startDate="
				+ startDate + ", endDate=" + endDate + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", bookingDate=" + bookingDate + "]";
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
