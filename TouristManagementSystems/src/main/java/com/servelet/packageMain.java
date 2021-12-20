package com.servelet;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daoImplement.PackageModeClassDaoImplement;
import com.model.PackageModeClass;
import com.model.UserClass;

public class packageMain {
	
	Scanner sc = new Scanner(System.in);
	
	
	public void packageInsert() {
		
		try {
		System.out.println("enter package name:");
		String packageName =  sc.nextLine();
		System.out.println("enter two days package price");
		double twoDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter three days package price");
		double threeDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter four days package price");
		double fourDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter season");
		String season = sc.nextLine();
		System.out.println("enter the protocol:");
		String protocol = sc.nextLine();
		System.out.println("enter the description: ");
		String description = sc.nextLine();
		
		PackageModeClass  packageModel = new PackageModeClass(packageName, twoDayPrice, threeDayPrice, fourDayPrice, season, protocol, description);
		    // System.out.println(packageModel);

		
		 PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
				 boolean insert = packageDao.insertPackage(packageModel);
			
			if(insert==true) {
				System.out.println("insert successfully🧡💥");
			}
			else {
				System.out.println("enter the correct values");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
		
	
	
	public void packageUpdate() {


		try {
		
		System.out.println("enter the package id :");
		int packageId = Integer.parseInt(sc.nextLine());
		System.out.println("enter package name:");
		String packageName =  sc.nextLine();
		System.out.println("enter two days package price");
		double twoDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter two days package price");
		double threeDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter two days package price");
		double fourDayPrice = Double.parseDouble(sc.nextLine());
		System.out.println("enter season");
		String season = sc.nextLine();
		System.out.println("enter the protocol:");
		String protocol = sc.nextLine();
		System.out.println("enter the description: ");
		String description = sc.nextLine();
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		PackageModeClass packages = new PackageModeClass(packageId,packageName, twoDayPrice, threeDayPrice, fourDayPrice, season, protocol, description);
			boolean update = packageDao.updatePackage(packages);
			if(update==true){
				System.out.println("update successfull");
			}
			else {
				System.out.println("please enter the correct value");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
			
		}
	
	
	
		
public void delete(){
	try {
	System.out.println("enter the package id");
	int packageId = Integer.parseInt(sc.nextLine());
        
	PackageModeClassDaoImplement packages = new PackageModeClassDaoImplement();
	boolean delete = packages.deletePackage(packageId);
	if(delete==true){
		System.out.println("delete successfull");
	}
	else {
		System.out.println("please enter the correct value");
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}

public void showAllPackage() {
	try {
	PackageModeClass showAllPackage = new PackageModeClass();
	PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();

	List<PackageModeClass> packages = packageDao.getAllPackage();
	// System.out.println("second");
	for (int i = 0; i < packages.size(); i++) {

		System.out.println(packages.get(i));

	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
	

}
