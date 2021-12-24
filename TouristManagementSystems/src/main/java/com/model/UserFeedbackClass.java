package com.model;

import java.util.Objects;

public class UserFeedbackClass {
	private int feedbackId;
	private int userId;
	private int bookingId;
	private int packageId;
	private float rating;
	private String describtion;
	
	public UserFeedbackClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserFeedbackClass(int feedbackId,int userId, int bookingId, int packageId,  float rating,
			String describtion) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.bookingId = bookingId;
		this.packageId = packageId;
		this.rating = rating;
		this.describtion = describtion;
	}



	public UserFeedbackClass(int bookingId,int userId, int packageId, float rating, String describtion) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.packageId = packageId;
		this.rating = rating;
		this.describtion = describtion;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
		return "UserFeedbackClass [feedbackId=" + feedbackId + ", userId=" + userId + ", bookingId=" + bookingId
				+ ", packageId=" + packageId + ", rating=" + rating + ", describtion=" + describtion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, describtion, feedbackId, packageId, rating);
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
				&& feedbackId == other.feedbackId && packageId == other.packageId
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating);
	}

	
	
}
