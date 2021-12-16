package com.module;

import java.util.Objects;

public class FlightClass {

	private int bookingId;
	private String flightName;
	private String destination;
	private String arrival;
	private String depatureTime;
	private String arrivalTime;
	private double businessClassFare;
	private double economicClassFare;
	private String status;
	
	public FlightClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightClass(int bookingId, String flightName, String destination, String arrival, String depatureTime,
			String arrivalTime, double businessClassFare, double economicClassFare, String status) {
		super();
		this.bookingId = bookingId;
		this.flightName = flightName;
		this.destination = destination;
		this.arrival = arrival;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.businessClassFare = businessClassFare;
		this.economicClassFare = economicClassFare;
		this.status = status;
	}
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(double businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public double getEconomicClassFare() {
		return economicClassFare;
	}

	public void setEconomicClassFare(double economicClassFare) {
		this.economicClassFare = economicClassFare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FlightClass [bookingId=" + bookingId + ", flightName=" + flightName + ", destination=" + destination
				+ ", arrival=" + arrival + ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime
				+ ", businessClassFare=" + businessClassFare + ", economicClassFare=" + economicClassFare + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrival, arrivalTime, bookingId, businessClassFare, depatureTime, destination,
				economicClassFare, flightName, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightClass other = (FlightClass) obj;
		return Objects.equals(arrival, other.arrival) && Objects.equals(arrivalTime, other.arrivalTime)
				&& bookingId == other.bookingId
				&& Double.doubleToLongBits(businessClassFare) == Double.doubleToLongBits(other.businessClassFare)
				&& Objects.equals(depatureTime, other.depatureTime) && Objects.equals(destination, other.destination)
				&& Double.doubleToLongBits(economicClassFare) == Double.doubleToLongBits(other.economicClassFare)
				&& Objects.equals(flightName, other.flightName) && Objects.equals(status, other.status);
	}
	
	
	
	
}
