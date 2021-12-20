package com.model;

import java.time.LocalDate;
import java.util.Objects;

public class BookingClass {
	
	private int bookingId;
	private int userId;
	private int packageIid;
	private int flightNo;
	private int noOfPerson;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalPrice;
	private String status;
	public BookingClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingClass(int bookingId, int userId, int packageIid, int flightNo, int noOfPerson, LocalDate startDate,
			LocalDate endDate, double totalPrice, String status) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.packageIid = packageIid;
		this.flightNo = flightNo;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
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
	@Override
	public String toString() {
		return "BookingClass [bookingId=" + bookingId + ", userId=" + userId + ", packageIid=" + packageIid
				+ ", flightNo=" + flightNo + ", noOfPerson=" + noOfPerson + ", startDate=" + startDate + ", endDate="
				+ endDate + ", totalPrice=" + totalPrice + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, endDate, flightNo, noOfPerson, packageIid, startDate, status, totalPrice,
				userId);
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
		return bookingId == other.bookingId && Objects.equals(endDate, other.endDate) && flightNo == other.flightNo
				&& noOfPerson == other.noOfPerson && packageIid == other.packageIid
				&& Objects.equals(startDate, other.startDate) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	
	
	
	
	
	
	

}
