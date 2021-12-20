package com.module;

import java.util.Objects;

public class UserClass {
	
	private String name;
	private String email;
	private long mboNo;
	private String password;
	public UserClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserClass(String name, String email, long mboNo, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mboNo = mboNo;
		this.password = password;
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
	public long getMboNo() {
		return mboNo;
	}
	public void setMboNo(long mboNo) {
		this.mboNo = mboNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserClass [name=" + name + ", email=" + email + ", mboNo=" + mboNo + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, mboNo, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserClass other = (UserClass) obj;
		return Objects.equals(email, other.email) && mboNo == other.mboNo && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
	

}
