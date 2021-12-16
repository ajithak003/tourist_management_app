package com.module;

import java.util.Objects;

public class UserFeedbackClass {
	
	private int packageId;
	private int bookingId;
	private String packageName;
	private String startDate;
	private String endDate;
	private float rating;
	private String describtion;
	public UserFeedbackClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserFeedbackClass(int packageId, int bookingId, String packageName, String startDate, String endDate,
			float rating, String describtion) {
		super();
		this.packageId = packageId;
		this.bookingId = bookingId;
		this.packageName = packageName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
		this.describtion = describtion;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	@Override
	public String toString() {
		return "UserFeedbackClass [packageId=" + packageId + ", bookingId=" + bookingId + ", packageName=" + packageName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", rating=" + rating + ", describtion="
				+ describtion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, describtion, endDate, packageId, packageName, rating, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFeedbackClass other = (UserFeedbackClass) obj;
		return bookingId == other.bookingId && Objects.equals(describtion, other.describtion)
				&& Objects.equals(endDate, other.endDate) && packageId == other.packageId
				&& Objects.equals(packageName, other.packageName)
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating)
				&& Objects.equals(startDate, other.startDate);
	}

	
}
