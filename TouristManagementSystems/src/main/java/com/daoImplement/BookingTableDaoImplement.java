package com.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.BookingDaoInterface;
import com.model.BookingClass;

public class BookingTableDaoImplement implements BookingDaoInterface {

	@Override
	public boolean insertbooking(BookingClass booking) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String commit = "commit";
		String insert = "insert into booking_details (user_id, package_id, flight_no, hotel_id,number_of_person,start_date,end_date,total_price) values(?,?,?,?,?,?,?,?)";
		
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
	public List<BookingClass> getAllbooking() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingClass getbookingById(BookingClass booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatebooking(String name, String email, long mobileNo, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletebooking(BookingClass booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookingClass validatebooking(String emailId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
