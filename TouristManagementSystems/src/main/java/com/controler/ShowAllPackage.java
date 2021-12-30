package com.controler;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImplement.PackageModeClassDaoImplement;
import com.model.PackageModeClass;

public class ShowAllPackage extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		
		try {
			
			
			
			  
			
			PackageModeClass showAllPackage = new PackageModeClass();
			PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();

			List<PackageModeClass> packages = packageDao.getAllPackage();
			 System.out.println("second");
			 
			 
//			for (int i = 0; i < packages.size(); i++) {
//		
//				System.out.println(packages.get(i));
//
//			}
			 req.setAttribute("package", packages);
				System.out.println("Inside 1");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("showPackage.jsp");
				requestDispatcher.forward(req, res);
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
