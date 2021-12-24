package com.servelet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.daoImplement.BookingTableDaoImplement;
import com.daoImplement.RatingDaoImplement;
import com.model.BookingClass;
import com.model.UserClass;
import com.model.UserFeedbackClass;

public class RatingMain {
	
	Scanner sc = new Scanner (System.in);
	
	public void userRating(UserClass user) {
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("\n enter the planning date enter ");
		String planningDate = sc.nextLine(); // "2021-12-21";
		LocalDate startDate = LocalDate.parse(planningDate, formatter);

		BookingTableDaoImplement book = new BookingTableDaoImplement();
		BookingClass booking = book.getbookingById(user.getId(),startDate);
		System.out.println(booking);
		RatingDaoImplement rating = new RatingDaoImplement();
		boolean eligible = rating.endDateCheck(booking);
		
		if(eligible==true) {
			
			System.out.println("please give your rating in points (1.0 to 5.0)");
			String points = sc.nextLine();
			float point =0.0f;
			
			if((points.matches("[1-5]"))){
				point=Float.parseFloat(points);
		
			
			System.out.println("How would you describe the amzing experience?");
			String describe = sc.nextLine();
			UserFeedbackClass feedBack = new UserFeedbackClass(booking.getBookingId(),user.getId(),booking.getPackageIid(),point,describe);
		
				boolean insert = rating.insertFeedback(feedBack);
			if(insert==true) {
				System.out.println("Thank you for your goldan review!");
			}
		}
			else {
				System.out.println("enter a correct value");
			}
			
		}
		else {
			System.out.println("your not a eligile to give a rating \n"
					+ "once you finish a tour then you are eligible for given your valid feed back");
		}
		
	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}

}
