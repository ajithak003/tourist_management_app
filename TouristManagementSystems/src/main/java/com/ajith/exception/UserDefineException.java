package com.ajith.exception;

public class UserDefineException extends Exception{

	public String invalidPassword() {
		
		return "Invalid Username and Password";
	}
	
	public String reregister() {
		
		return "This Email Id Already Registered! \n if you want to change mobile no or password login and update your accout";
	}

}