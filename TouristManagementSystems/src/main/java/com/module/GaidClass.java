package com.module;

import java.util.Objects;

public class GaidClass {
	
	
	private String name;
	private String email;
	private long mobileNo;
	private String password;
	private String address;
	public GaidClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GaidClass(String name, String email, long mobileNo, String password, String address) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "GaidClass \n name=" + name + ",\n email=" + email + ",\n mobileNo=" + mobileNo + ",\n password=" + password
				+ ",\n address=" + address + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GaidClass other = (GaidClass) obj;
		return Objects.equals(email, other.email);
	}
	
	

}
