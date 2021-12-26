package com.daoImplement;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



import com.connection.ConnectionUtil;
import com.daoInterface.FlightDaoInterface;
import com.model.FlightClass;


public class FlightTableDaoImplement implements FlightDaoInterface {

	@Override
	public boolean insertFlight(FlightClass flight) {
		// TODO Auto-generated method stub
	
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
//		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
//		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		
		String commit = "commit";
		String insert = "insert into flights_details (flight_name,depature,destination,depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status,business_class_seat_status,economic_class_seat_status)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           

			pstmt.setString(1,flight.getFlightName());
			pstmt.setString(2,flight.getDepature() );
			pstmt.setString(3,flight.getDestination());
			Timestamp depatureDateTime = Timestamp.valueOf(flight.getDepatureDateTime());
			pstmt.setTimestamp(4,depatureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(flight.getArrivalDateTime());
			pstmt.setTimestamp(5,arrivalDateTime);
//			pstmt.setTimestamp(4, flight.getDepatureDateTime());
//			pstmt.setTimestamp(5, flight.getArrivalDateTime());
			pstmt.setDouble(6, flight.getBusinessClassFare());
			pstmt.setDouble(7, flight.getEconomicClassFare());
			pstmt.setString(8, flight.getStatus());
			pstmt.setInt(9, flight.getBusinessClassSeat());
			pstmt.setInt(10, flight.getEconomicClassSeat());
			
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
	public boolean updateFlight(FlightClass flight)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		
		String commit = "commit";
		String insert = "update flights_details set flight_name=?,depature=?,destination=?,depature_date_time=?,arrival_date_time=?,business_class_fare=?,economic_class_fare=?,status=?,business_class_seat_status=?,economic_class_seat_status=?"
				+ " where flight_no=?";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           

			pstmt.setString(1,flight.getFlightName());
			pstmt.setString(2,flight.getDepature() );
			pstmt.setString(3,flight.getDestination());
			Timestamp depatureDateTime = Timestamp.valueOf(flight.getDepatureDateTime());
			pstmt.setTimestamp(4,depatureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(flight.getArrivalDateTime());
			pstmt.setTimestamp(5,arrivalDateTime);
//			pstmt.setTimestamp(4, flight.getDepatureDateTime());
//			pstmt.setTimestamp(5, flight.getArrivalDateTime());
			pstmt.setDouble(6, flight.getBusinessClassFare());
			pstmt.setDouble(7, flight.getEconomicClassFare());
			pstmt.setString(8, flight.getStatus());
			pstmt.setInt(9, flight.getBusinessClassSeat());
			pstmt.setInt(10, flight.getEconomicClassSeat());
			pstmt.setInt(11, flight.getFlightNo());
			
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
	public boolean deleteFlight(int flightNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "delete flights_details where flight_no=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            
            pstmt.setInt(1,flightNo);
			
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
	public List<FlightClass> getAllFlight() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		List<FlightClass> flightDetails = new ArrayList<FlightClass>();
		Connection con = null;
		//System.out.println("connection");
		String query = "select * from flights_details";
		//String query = "select flight_no, flight_name,depature,destination, depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status from flights_details";
		//select flight_no, flight_name,depature,destination,to_char(depature_date_time,'dd-mm-yyyy hh:mm') as depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status from flights_details ;
		Statement stmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   
			FlightClass flight = new  FlightClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(),rs.getDouble(7),rs.getDouble(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
			flightDetails.add(flight);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return flightDetails;
		
	}



	@Override
	public List<FlightClass> getFlightByNo(String location, LocalDate startDate)  {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		//PreparedStatement pstmt =null;
		
		FlightClass flight= null;
		
		List<FlightClass> flights = new ArrayList<FlightClass>();

		String query = "select * from flights_details where destination='"+location+"' and to_char(depature_date_time,'yyyy-mm-dd')='"+startDate+"'";
				
		String commit = "commit";
		
		try {
			con = ConnectionUtil.getDBConnect();
			// pstmt = con.prepareStatement(query);
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				flight = new FlightClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(),rs.getDouble(7),rs.getDouble(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
				flights.add(flight);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		
		return flights;
	}

	@Override
	public FlightClass validateFlight(String emailId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FlightClass getSingleFlight(int flightNo)  {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		//PreparedStatement pstmt =null;
		
		FlightClass flight= null;
		
		String query = "select * from flights_details where flight_no="+flightNo;
		
		try {
			con = ConnectionUtil.getDBConnect();
			// pstmt = con.prepareStatement(query);
			
			 stmt =con.createStatement();
			
			 ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				flight = new FlightClass(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime(),rs.getDouble(7),rs.getDouble(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		
		return flight;
	
	}
}
