package com.servelet;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.daoImplement.BookingTableDaoImplement;
import com.daoImplement.FlightTableDaoImplement;
import com.daoImplement.HotelTableDaoImplement;
import com.daoImplement.PackageModeClassDaoImplement;
import com.daoImplement.UserTableDaoImplement;
import com.model.BookingClass;
import com.model.FlightClass;
import com.model.HotelClass;
import com.model.PackageModeClass;
import com.model.UserClass;

public class BookingMain {
	
	Scanner sc = new Scanner (System.in);
	
	public void bookingInsert(UserClass user) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd"); 
		try {
			//System.out.println(user);
		UserTableDaoImplement userDao = new UserTableDaoImplement(); 
		UserClass userDetails = userDao.getUserById(user);
		//System.out.println(userDetails);
		
		DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		packageMain packages = new packageMain();
		List<PackageModeClass> showALLPackage = packages.showAllUserPackage();
		for (int i = 0; i < showALLPackage.size(); i++) {
				System.out.println(showALLPackage.get(i));
				}
					
		System.out.println("enter the location");
		String location = sc.nextLine();

		System.out.println("enter the planning date enter ");
		String planningDate = sc.nextLine(); //"2021-12-21 05:30";
		LocalDate startDate = LocalDate.parse(planningDate, formatter);
		
		String endDate = planningDate.substring(0, 10);
		
		
		
		PackageModeClass singlePackage=null;
		for(PackageModeClass p:showALLPackage) {
			if(p.getName().equalsIgnoreCase(location)) {
				singlePackage=p;
			}
		}
		System.out.println(singlePackage);
		double totalPrice = 0.0;
		boolean plan = true;
		int end =0;
		do {	
		
		System.out.println("enter the choice 1. 2 days night plan \n 2. 3 days night plan 3. 4 days night plan");
	       int daysPlan = Integer.parseInt(sc.nextLine());
	      
	       if(daysPlan==1) {
	    	   daysPlan=3;
	    	   plan=false;
	    	   end=2;
	    	   totalPrice = totalPrice+ singlePackage.getPriceTwoDays();
	       }
	       else if(daysPlan==2) {
	    	   daysPlan=4;
	    	   plan=false;
	    	   end=3;
	    	   totalPrice = totalPrice + singlePackage.getPriceThreeDays();
	       }
	       else if(daysPlan==3) {
	    	   daysPlan=5;
	    	   plan=false;
	    	   end=4;
	    	   totalPrice = totalPrice + singlePackage.getPricefourDays();
	       }
	       else {
	    	   System.out.println("enter the correct value");
	       }
		}while (plan);
	      
		 System.out.println(totalPrice);
		
	
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		List<FlightClass> flights =flightDao.getFlightByNo(location,startDate);
		for (int i = 0; i < flights.size(); i++) {

			System.out.println(flights.get(i));

		}
		
			
		System.out.println("choose your depature location given below available flights");
		String depatureLocation = sc.nextLine();
		
		FlightClass singleFlight=null;
		for(FlightClass f:flights) {
			if(f.getDepature().equalsIgnoreCase(depatureLocation)) {
				singleFlight=f;
			}
		}
		
		System.out.println(singleFlight);
		
		System.out.println("enter the 1. business class 2.economic class");
		int flightClassRate = Integer.parseInt(sc.nextLine());
		
		if(flightClassRate==1) {
			flightClassRate=4;
			totalPrice = totalPrice + singleFlight.getBusinessClassFare();
			
		}
		else if(flightClassRate==2) {
			flightClassRate=5;
			totalPrice = totalPrice + singleFlight.getEconomicClassFare();
			
		}
		else {
			System.out.println("please enter correct value");
		}
		
		
		 System.out.println(totalPrice);

			HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
			List<HotelClass> hotels = hotelDao.getHotelByNo(location);
			for (int i = 0; i < hotels.size(); i++) {

				System.out.println(hotels.get(i));
			}
			
		System.out.println("choose the hotel name");
		String hotelName = sc.nextLine();
		
		HotelClass singleHotel=null;
		for(HotelClass h:hotels) {
			if(h.getHotelName().equalsIgnoreCase(hotelName) && h.getLocation().equalsIgnoreCase(location)) {
				singleHotel=h;
			}
		}
		
		System.out.println(singleHotel);
		
		boolean roomType = true;
		do {
		System.out.println("enter the room type 1.mid range\n 2. premium");
		int hotelRoomType = Integer.parseInt(sc.nextLine());
		 
		if(hotelRoomType==1) {
			hotelRoomType =4;
			totalPrice= totalPrice + singleHotel.getMidRangePrice();
			roomType=false;
		}
		else if(hotelRoomType==2) {
			hotelRoomType=5;
			totalPrice= totalPrice + singleHotel.getPremiumPrice();
			roomType=false;
		}
		else {
			System.out.println("enter the correct value");
		}
		
		}while(roomType);
		
		long ONE_DAY_MILLI_SECONDS = (24 * 60 * 60 * 1000)*end;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = sdf.parse(endDate);
		
		 endDate = sdf.format(date.getTime() + ONE_DAY_MILLI_SECONDS);
		 LocalDate endDates = LocalDate.parse(endDate);
		 

	        System.out.println("end date"+endDate+"\n\n");
	        System.out.println("total amount of 2 adult:   "+totalPrice);
		 
		 System.out.println("enter the number of person (above 2 person the total amount is increse)!");
		 int noOfPerson = Integer.parseInt(sc.nextLine());
          
		 if(noOfPerson>2) {
			 
			 double price = totalPrice/2;
			 
			 totalPrice = price * noOfPerson;
			 System.out.println(noOfPerson+" total amount "+totalPrice);
		 }
		 
			 
			 BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
			 BookingClass booking = new BookingClass(userDetails.getId(),singlePackage.getPackageId(), singleFlight.getFlightNo(), singleHotel.getHotelId(),noOfPerson,startDate ,endDates,totalPrice);
			 System.out.println(booking);
			boolean book= bookDao.insertbooking(booking);
			if(book==true) {
				System.out.println("successfully booked");
			}
			else {
				System.out.println("unable to booking \n please try again");
			}
			
		
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
