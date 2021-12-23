package com.daoImplement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionUtil;
import com.daoInterface.PackageModeDaoInterface;

import com.model.PackageModeClass;
import com.model.UserClass;


public class PackageModeClassDaoImplement implements PackageModeDaoInterface{

	@Override
	public boolean insertPackage(PackageModeClass Packages) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int pstmtvalue = 0;
		String commit = "commit";
		String insert = "insert into package_modes(package_name,package_price_2n,package_price_3n,package_price_4n,season,protocols,description) values(?,?,?,?,?,?,?)";
		
		try {
			con = ConnectionUtil.getDBConnect();
			
			pstmt = con.prepareStatement(insert);
           
//		String date1=dateFormatMDY.format(employees.getHire());
			pstmt.setString(1, Packages.getName());
			pstmt.setDouble(2, Packages.getPriceTwoDays());
			pstmt.setDouble(3, Packages.getPriceThreeDays());
			pstmt.setDouble(4, Packages.getPricefourDays());
			pstmt.setString(5, Packages.getSeason());
			pstmt.setString(6, Packages.getProtocols());
			pstmt.setString(7, Packages.getDescription());
			
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
	public boolean updatePackage(PackageModeClass packages) {
		// TODO Auto-generated method stub
		Connection con = null;
		int update=0;
		String commit = "commit";
		String query = "update package_modes set package_name=?,package_price_2n=?,package_price_3n=?,package_price_4n=?,season=?,protocols=?,description=? where package_id=?";
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			

//		String date1=dateFormatMDY.format(employees.getHire());
			
			pstmt.setString(1, packages.getName());
			pstmt.setDouble(2, packages.getPriceTwoDays());
			pstmt.setDouble(3, packages.getPriceThreeDays());
			pstmt.setDouble(4, packages.getPricefourDays());
			pstmt.setString(5, packages.getSeason());
			pstmt.setString(6, packages.getProtocols());
			pstmt.setString(7, packages.getDescription());
			pstmt.setInt(8, packages.getPackageId());
			//System.out.println(packages.getPackageId());
//			System.out.println("execute");
		    update = pstmt.executeUpdate();
			 pstmt.executeQuery(commit);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
			
		}
           return update>0;
	
	}


	@Override
	public List<PackageModeClass> getAllPackage() {
		// TODO Auto-generated method stub
		
		List<PackageModeClass> packageList = new ArrayList<PackageModeClass>();
		Connection con = null;
		//System.out.println("connection");
		String query = "select * from package_modes";

		Statement stmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			PackageModeClass packages = new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getString(8));
			packageList.add(packages);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}

		return packageList;
		
	}

	@Override
	public PackageModeClass getPackageByNo(String PackageName) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packageById=null;
		
		
		String query ="select * from package_modes where package_name=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 
		 pstmt.setString(1,PackageName);
		 
		 ResultSet rs = pstmt.executeQuery(query);
		
		 
		 if (rs.next()) {

			 packageById=new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getString(8));
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return packageById;
	}

	
	@Override
	public boolean deletePackage(int packageId) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt =null;
		int del=0;
		String query = "delete package_modes where package_id=?";
		String commit = "commit";
		
		try {
			
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
           
            
            pstmt.setInt(1,packageId);
			
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
	public PackageModeClass validatePackage(String emailId, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PackageModeClass getSinglePackage(int packageId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PackageModeClass packages=null;
		
		
		String query ="select * from package_modes where package_id="+packageId;
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		 
		 ResultSet rs = pstmt.executeQuery(query);
		
		 
		 if (rs.next()) {

			 packages=new  PackageModeClass(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getString(8));
				
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				ConnectionUtil.closePreparedStatement(pstmt, con);
			}
		 return packages;
	}
	
	
}