package com.module;

import java.util.Objects;

public class UserClass {
     
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserClass(int id, String name, String email, long mboNo, String password) {
		super();
		//System.out.println("super class");
		this.id = id;
		this.name = name;
		this.email = email;
		this.mboNo = mboNo;
		this.password = password;
	}

	private String name;
	private String email;
	private long mboNo;
	private String password;
	

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
		return "User : \n name=" + name + ", \n email=" + email + ",\n mobile no=" + mboNo + ",\n password=" + password + "]";
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
		UserClass other = (UserClass) obj;
		return Objects.equals(email, other.email);
	}
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

	public UserClass(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserClass(String email) {
		super();
		this.email = email;
	}
	
	


}