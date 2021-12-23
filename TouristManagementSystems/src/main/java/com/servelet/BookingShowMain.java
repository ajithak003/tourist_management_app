	package com.servelet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.daoImplement.AdminTableDaoImplement;
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

public class BookingShowMain {
	
	Scanner sc = new Scanner(System.in);
	
	public void show(UserClass user) {
		try {
		UserTableDaoImplement userDao = new UserTableDaoImplement(); 
			UserClass userDetails = userDao.getUserById(user);
			//System.out.println(user);
		System.out.println("enter the tour starting date : ");
		String startDatestr = sc.nextLine();
		LocalDate startDate = LocalDate.parse(startDatestr);
		BookingClass booking =null;
		BookingTableDaoImplement book = new BookingTableDaoImplement();
		booking = book.getbookingById(userDetails.getId(), startDate);
		//System.out.println(booking);
		
		PackageModeClassDaoImplement pack = new PackageModeClassDaoImplement();
		PackageModeClass pakages =pack.getSinglePackage(booking.getPackageIid());
		//System.out.println(pakages);
		
		FlightTableDaoImplement flights = new FlightTableDaoImplement();
		FlightClass flight = flights.getSingleFlight(booking.getFlightNo());
		//System.out.println(flight);
		
		HotelTableDaoImplement hotels = new HotelTableDaoImplement();
		HotelClass hotel = hotels.getSingleHotel(booking.getHotelId());
		//System.out.println(hotel);
		
		System.out.println(booking.toStringbook(userDetails, pakages, flight, hotel));
		
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void cancelBooking(UserClass user) {
		
		try {
			UserTableDaoImplement userDao = new UserTableDaoImplement(); 
				UserClass userDetails = userDao.getUserById(user);
				
				System.out.println("enter the tour starting date : ");
				String startDatestr = sc.nextLine();
				LocalDate startDate = LocalDate.parse(startDatestr);
				
				BookingTableDaoImplement cancel = new BookingTableDaoImplement();
				BookingClass book = cancel.getbookingById(user.getId(), startDate);
				double refundPrice =  user.getWallet()+ book.getTotalPrice();
				boolean cancelBooking = cancel.updatebooking(user.getId(), startDate,refundPrice);
				
				if(cancelBooking==true) {
					System.out.println("successfully canceled");
				}
				else {
					System.out.println("unable to cancel your booking please try again later");
				}
				
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void showAllBooking(UserClass user) {
		
		UserTableDaoImplement userDao = new UserTableDaoImplement(); 
		try {
			UserTableDaoImplement userDao1 = new UserTableDaoImplement();
			UserClass userDetails = userDao1.getUserById(user);
			BookingTableDaoImplement showAllBooking = new BookingTableDaoImplement();
			
            List<BookingClass> booking = showAllBooking.getAllbooking(userDetails);
			
			for (int i = 0; i < booking.size(); i++) {

				System.out.println("user name : "+userDetails.getName()+"\n"+booking.get(i));
			}
			
			System.out.println("choose 1. if your want to see particular booking in full details 2. exit programe");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice==1) {
				BookingShowMain details = new BookingShowMain();
				details.show(userDetails);
			}
			else {
				System.exit(0);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(user);
	
		
	}
	
	public void showAllUserBookings() {
		
		BookingTableDaoImplement showAllBooking = new BookingTableDaoImplement();
		
        List<BookingClass> booking = showAllBooking.getAllUserBooking();
        
        try {
		for (BookingClass b:booking) {
             
			int userId=b.getUserId();
			AdminTableDaoImplement admin =new AdminTableDaoImplement();
			//System.out.println(userId);
		    UserClass user = admin.getUserById(userId);
			
				System.out.println("BookingClass \n\nUserName :  "+user.getName()+"\n User Email id :  "+user.getEmail()+"\n Tourist Location="+b.getPackageName()+"\n Booking Date :  "
				+b.getBookingDate()+"\n startDate=" + b.getStartDate() + "\n endDate=" + b.getEndDate()
						+ "\n totalPrice=" + b.getTotalPrice() + "\n noOfPerson=" + b.getNoOfPerson() + "\n status=" + b.getStatus()+ 
						 "\n flightClass=" + b.getFlightClass() + "\n hotelRoomType=" + b.getFlightClass() + "\n daysPlan=" + b.getDaysPlan());
			
			
			
		}
        }catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		}
		
	}


