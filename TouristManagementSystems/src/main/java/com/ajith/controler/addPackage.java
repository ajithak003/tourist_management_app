package com.ajith.controler;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajith.daoImplement.PackageModeClassDaoImplement;
import com.ajith.model.PackageModeClass;


@WebServlet(urlPatterns = "/addpackage")
public class addPackage extends HttpServlet {

	Scanner sc = new Scanner(System.in);

	public void service(HttpServletRequest req, HttpServletResponse res)  {
		try {
		PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
		
		String packagename = req.getParameter("packagename");
		//System.out.println(packagename);
		
		double packageOneDayPrice = Double.parseDouble(req.getParameter("packageonedayprice"));
		//System.out.println(packageOneDayPrice);
		
		String season = req.getParameter("season");
		//System.out.println(season);
		
		String protocol = req.getParameter("protocol");
		//System.out.println(protocol);
		
		String description = req.getParameter("description");
		//System.out.println(description);
		
		String image = req.getParameter("packageimage");
		//System.out.println(image);

		
		PackageModeClass packages = new PackageModeClass(packagename,packageOneDayPrice,season,protocol,description,image);
		//ystem.out.println(packages);
		boolean pack = packageDao.insertPackage(packages);
		
		HttpSession session = req.getSession();
		if(pack==true) {
			System.out.println("insert success");
			req.getRequestDispatcher("addPackage.jsp").forward(req,res);
			session.setAttribute("addpackage", "true");
		}
		else {
			System.out.println("insert invalid");
			session.setAttribute("addpackage", "false");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
