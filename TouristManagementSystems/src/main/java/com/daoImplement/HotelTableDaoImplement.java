package com.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.HotelDaoInterface;
import com.model.FlightClass;
import com.model.HotelClass;

public class HotelTableDaoImplement implements HotelDaoInterface {

	@Override
	public boolean insertHotel(HotelClass hotel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String commit = "commit";
		String insert = "insert into hotel_details (location, hotel_name, room_type_mid_range_price, room_type_premium_price) values(?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			
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
	public boolean updateHotel(HotelClass hotel)
		 {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String update = "update hotel_details set location=?,hotel_name=?,room_type_mid_range_price=?,room_type_premium_price=? where hotel_id=?";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(update);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setInt(5, hotel.getHotelId());
//			
			pstmtvalue = pstmt.executeUpdate();
			
			
			pstmt.executeQuery(commit);

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
	public boolean deleteHotel(int hotelId)  {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "delete hotel_details where hotel_id=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            
            pstmt.setInt(1,hotelId);
			
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
	public List<HotelClass> getAllHotel()  {
		// TODO Auto-generated method stub
		List<HotelClass> hotelDetails = new ArrayList<HotelClass>();
		Connection con = null;
		//System.out.println("connection");
		String query = "select * from hotel_details";
		Statement stmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			HotelClass hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
			hotelDetails.add(hotel);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return hotelDetails;
	}
	
	@Override
	public List<HotelClass> getHotelByNo(String location) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		
		
		HotelClass hotel= null;
		
		List<HotelClass> hotels = new ArrayList<HotelClass>();

		String query = "select * from hotel_details where location='"+location+"'";
				
		String commit = "commit";
		
		try {
			con = ConnectionUtil.getDBConnect();
			// pstmt = con.prepareStatement(query);
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
				hotels.add(hotel);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		
		return hotels;
		
	}


	@Override
	public HotelClass validateHotel(String emailId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
