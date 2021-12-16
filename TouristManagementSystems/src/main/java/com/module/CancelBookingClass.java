package com.module;

import java.util.Objects;

public class CancelBookingClass {

	private int bookingId;
	private int userId;
	private int flight_no;
	private String packageName;
	private int noOfPerson;
	private String startDate;
	private String endDate;
	private double totalPrice;
	private int gaidId;
	public CancelBookingClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CancelBookingClass(int bookingId, int userId, int flight_no, String packageName, int noOfPerson,
			String startDate, String endDate, double totalPrice, int gaidId) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flight_no = flight_no;
		this.packageName = packageName;
		this.noOfPerson = noOfPerson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.gaidId = gaidId;
	}
	public CancelBookingClass(int bookingId, int userId, int flight_no, String packageName, int noOfPerson,
			String startDate, String endDate, double totalPrice) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flight_no = flight_no;
		this.packageName = packageName;
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
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getGaidId() {
		return gaidId;
	}
	public void setGaidId(int gaidId) {
		this.gaidId = gaidId;
	}
	@Override
	public String toString() {
		return "CancelBookingClass [bookingId=" + bookingId + ", userId=" + userId + ", flight_no=" + flight_no
				+ ", packageName=" + packageName + ", noOfPerson=" + noOfPerson + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", totalPrice=" + totalPrice + ", gaidId=" + gaidId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, endDate, flight_no, noOfPerson, packageName, startDate, totalPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancelBookingClass other = (CancelBookingClass) obj;
		return bookingId == other.bookingId && Objects.equals(endDate, other.endDate) && flight_no == other.flight_no
				&& noOfPerson == other.noOfPerson && Objects.equals(packageName, other.packageName)
				&& Objects.equals(startDate, other.startDate)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	
}
