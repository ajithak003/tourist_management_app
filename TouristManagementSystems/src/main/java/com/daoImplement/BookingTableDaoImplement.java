package com.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.BookingDaoInterface;
import com.model.BookingClass;
import com.model.FlightClass;
import com.model.HotelClass;
import com.model.UserClass;

public class BookingTableDaoImplement implements BookingDaoInterface {

	@Override
	public boolean insertbooking(BookingClass booking) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String commit = "commit";
		String insert = "insert into booking_details (user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price,flight_class,hotel_room_type,days_in_night,package_name) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
			pstmt.setInt(1,booking.getUserId() );
			pstmt.setInt(2,booking.getPackageIid());
			pstmt.setInt(3,booking.getFlightNo());
			pstmt.setInt(4, booking.getHotelId());
			pstmt.setInt(5, booking.getNoOfPerson());
			pstmt.setDate(6, java.sql.Date.valueOf(booking.getStartDate()));
			pstmt.setDate(7, java.sql.Date.valueOf(booking.getEndDate()));
			pstmt.setDouble(8, booking.getTotalPrice());
			pstmt.setString(9, booking.getFlightClass());
			pstmt.setString(10, booking.getHotelRoomType());
			pstmt.setString(11, booking.getDaysPlan());
			pstmt.setString(12, booking.getPackageName());
			
//			System.out.println(insert);
			pstmtvalue = pstmt.executeUpdate();
			
			//System.out.println(user.getEmail());
			pstmt.executeQuery(commit);

			// System.out.println( stmt.executeUpdate()+" Row Instered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue > 0;	
		

	}

	@Override
	public List<BookingClass> getAllbooking(UserClass user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<BookingClass> bookingDetails = new ArrayList<BookingClass>();
		Connection con = null;
		
		String query = "select * from booking_details where user_id="+user.getId();
	
		Statement stmt = null;
		BookingClass booking = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
			 bookingDetails.add(booking);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return bookingDetails;
	}

	@Override
	public BookingClass getbookingById(int user_id, LocalDate startDate) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		BookingClass booking=null;
		String query = "select * from booking_details where to_char(start_date,'yyyy-mm-dd')='"+startDate+"' and user_id="+user_id;
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));		
		
				
		}
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		return booking;
	}

	@Override
	public boolean updatebooking(int user_id, LocalDate startDate,double refundPrice)
			 {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtUser = null;
		int pstmtvalue = 0;
		String update = "cancel";
		String query = "update booking_details set status='"+update+"',payment_details='"+"payment refunded"+"' where user_id="+user_id+"and to_char(start_date,'yyyy-mm-dd')='"+startDate+"'";
		String wallet = "update user_details set wallet="+refundPrice+"where user_id="+user_id;
		String commit = "commit";
		try {
		
		con = ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(query);
		pstmtUser =con.prepareStatement(wallet);
		
		pstmtvalue = pstmt.executeUpdate();
		pstmtUser.executeUpdate();
        pstmt.executeUpdate(commit);
        pstmtUser.executeUpdate(commit);
		}	catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return pstmtvalue>0;
	}

	@Override
	public boolean deletebooking(int userId, LocalDate startDate) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "delete booking_details where user_id="+userId+" and to_char(start_date,'yyyy-mm-dd')='"+startDate+"'";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			
            del = pstmt.executeUpdate();
            pstmt.executeUpdate(commit);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return del>0;

		
	}

	@Override
	public BookingClass validatebooking(String emailId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookingClass> getAllUserBooking() {
		// TODO Auto-generated method stub
		List<BookingClass> bookingDetails = new ArrayList<BookingClass>();
		Connection con = null;
		
		String query = "select * from booking_details ";
	
		Statement stmt = null;
		BookingClass booking = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			 booking = new BookingClass(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6), rs.getDate(7).toLocalDate(),rs.getDate(8).toLocalDate(),rs.getDouble(9),rs.getString(10),rs.getTimestamp(11).toLocalDateTime(),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
			 bookingDetails.add(booking);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return bookingDetails;
	}

	
	
}
