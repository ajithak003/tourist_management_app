package com.ajith.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.ajith.connection.ConnectionUtil;
import com.ajith.daoInterface.HotelDaoInterface;
import com.ajith.model.FlightClass;
import com.ajith.model.HotelClass;

public class HotelTableDaoImplement implements HotelDaoInterface {

	@Override
	public boolean insertHotel(HotelClass hotel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;

		String commit = "commit";
		String insert = "insert into hotel_details (location, hotel_name, room_type_mid_range_price, room_type_premium_price,image) values(?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getImage());
			
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
		String update = "update hotel_details set location=?,hotel_name=?,room_type_mid_range_price=?,room_type_premium_price=?, image=? where hotel_id=?";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(update);
           
			pstmt.setString(1,hotel.getLocation() );
			pstmt.setString(2,hotel.getHotelName());
			pstmt.setDouble(3,hotel.getMidRangePrice());
			pstmt.setDouble(4, hotel.getPremiumPrice());
			pstmt.setString(5, hotel.getImage());
			pstmt.setInt(6, hotel.getHotelId());
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
		String query = "update hotel_details set status=? where hotel_id=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            pstmt.setString(1, "inactive");
            pstmt.setInt(2,hotelId);
			
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
		String query = "select * from hotel_details where status='"+"active"+"'";
		Statement stmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			HotelClass hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(7));
			hotelDetails.add(hotel);
			//System.out.println(hotel);
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

		String query = "select * from hotel_details where location='"+location+"' and status='"+"active"+"'";
		//System.out.println(query);
				
		String commit = "commit";
		
		try {
			con = ConnectionUtil.getDBConnect();
			// pstmt = con.prepareStatement(query);
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(7));
				hotels.add(hotel);
				//System.out.println("dao "+hotel);
				
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
	public HotelClass getSingleHotel(int hotelId)  {
		// TODO Auto-generated method stub
		String query = "select * from hotel_details where hotel_id="+hotelId+" and status='"+"active"+"'";
		Connection con = null;
		Statement stmt = null; 
		HotelClass hotel = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			 hotel = new HotelClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(7));
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return hotel;
	}
	

}
