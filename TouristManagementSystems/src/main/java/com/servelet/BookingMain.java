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
					
		System.out.println("\n enter the location");
		String location = sc.nextLine();

		System.out.println("\n enter the planning date enter ");
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
		String days = null;
		do {	
		
		System.out.println("\n enter the choice 1. 2 days night plan \n 2. 3 days night plan 3. 4 days night plan");
	       int daysPlan = Integer.parseInt(sc.nextLine());
	      
	       if(daysPlan==1) {
	    	   days=" Two days night plan";
	    	   plan=false;
	    	   end=2;
	    	   totalPrice = totalPrice+ singlePackage.getPriceTwoDays();
	       }
	       else if(daysPlan==2) {
	    	   days=" Three days night plan";
	    	   plan=false;
	    	   end=3;
	    	   totalPrice = totalPrice + singlePackage.getPriceThreeDays();
	       }
	       else if(daysPlan==3) {
	    	   days=" four days night plan";
	    	   plan=false;
	    	   end=4;
	    	   totalPrice = totalPrice + singlePackage.getPricefourDays();
	       }
	       else {
	    	   System.out.println("\n enter the correct value");
	       }
		}while (plan);
	      
		// System.out.println(totalPrice);
		
	
		FlightTableDaoImplement flightDao = new FlightTableDaoImplement();
		List<FlightClass> flights =flightDao.getFlightByNo(location,startDate);
		for (int i = 0; i < flights.size(); i++) {

			System.out.println(flights.get(i));

		}
		
			
		System.out.println("\n choose your depature location given below available flights");
		String depatureLocation = sc.nextLine();
		
		FlightClass singleFlight=null;
		for(FlightClass f:flights) {
			if(f.getDepature().equalsIgnoreCase(depatureLocation)) {
				singleFlight=f;
			}
		}
		
		System.out.println(singleFlight);
		
		String flightClass = null;
		System.out.println("\n enter the 1. business class 2.economic class");
		int flightClassRate = Integer.parseInt(sc.nextLine());
		
		if(flightClassRate==1) {
			flightClass="business class";
			totalPrice = totalPrice + singleFlight.getBusinessClassFare();
			
		}
		else if(flightClassRate==2) {
			flightClass="economic class";
			totalPrice = totalPrice + singleFlight.getEconomicClassFare();
			
		}
		else {
			System.out.println("please enter correct value");
		}
		
		
		// System.out.println(totalPrice);

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
		
		String hotelRoom=null;
		boolean roomType = true;
		do {
		System.out.println("\n enter the room type 1.mid range\n 2. premium");
		int hotelRoomType = Integer.parseInt(sc.nextLine());
		 
		if(hotelRoomType==1) {
			hotelRoom = "mid range room";
			totalPrice= totalPrice + singleHotel.getMidRangePrice();
			roomType=false;
			
		}
		else if(hotelRoomType==2) {
			hotelRoom = " premimum room";
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
		 

	       // System.out.println("end date"+endDate+"\n\n");
	        System.out.println("total amount of 2 adult:   "+totalPrice);
		 
		 System.out.println("\n enter the number of person (above 2 person the total amount is increse)!");
		 int noOfPerson = Integer.parseInt(sc.nextLine());
          
		 if(noOfPerson>2) {
			 
			 double price = totalPrice/2;
			 
			 totalPrice = price * noOfPerson;
			 System.out.println(noOfPerson+" total amount "+totalPrice);
		 }
		 UserTableDaoImplement userWalletDao = new UserTableDaoImplement();
		  
		 if(user.getWallet()>=totalPrice) {
			 
			 BookingTableDaoImplement bookDao = new BookingTableDaoImplement();
			 BookingClass booking=null;
			 booking = new BookingClass(userDetails.getId(),singlePackage.getPackageId(), singleFlight.getFlightNo(), singleHotel.getHotelId(),noOfPerson,startDate ,endDates,totalPrice,flightClass,hotelRoom,days,location);
			 System.out.println(booking.toString1(booking));
			boolean book= bookDao.insertbooking(booking);
			
			long wallet = userDao.showWalletAmount(user);
			wallet=(long) (wallet-totalPrice);
			userWalletDao.addWalletAmount(user.getId(),wallet);
			if(book==true) {
				System.out.println("\n \n successfully booked \n\n\n"
						+ "get a amazing trip");
			}
			else {
				System.out.println("\n unable to booking \n please try again");
			}
		 }
		 
		 else {
			 
				long wallet = userDao.showWalletAmount(user);
				System.out.println(" Sorry! insufficient balance please add amount in your wallent \n Your Wallet Amount :  "+wallet);
				System.out.println("do you want to add wallet amount 1.yes or 2.no");
				int choice = Integer.parseInt(sc.nextLine());

						switch(choice) {
						case 1:
							
							System.out.println("enter the added amount:");
							long add = Long.parseLong(sc.nextLine());
							if(add>0) {
							long totalWalletAmount = wallet+add;
							
							boolean walletAdd = userWalletDao.addWalletAmount(user.getId(),totalWalletAmount);
							if(walletAdd) {
								System.out.println("transaction successfully");
								long wallets = userDao.showWalletAmount(user);
								System.out.println("Your Wallet Amount :  "+wallets);	
							}
							else
								System.out.println("transaction failed");
							}
							else {
								System.out.println("please enter a valid amount");
							}
		 }
		 }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
