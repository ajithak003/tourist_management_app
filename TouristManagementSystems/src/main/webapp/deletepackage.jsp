<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



l>
<head>
<meta charset="ISO-8859-1">
<title>Delete Package</title>
<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
     response.setHeader("progma", "no-cache");
	 response.setHeader("Expires", "0");%>
</head>
<body>

      
      
      <% String packageName = request.getParameter("packagname");
       //System.out.print(packageName);
       PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
    
       boolean packages = packageDao.deletePackage(packageName);
       if(packages==true) {
			//System.out.println("deleted");
			session.setAttribute("adminpackage", "delete");
			request.getRequestDispatcher("showAllAdminPackages.jsp").forward(request,response);
			
		}
		else {
			//System.out.println("invalid");
			session.setAttribute("adminpackage", "canotdelete");
			request.getRequestDispatcher("showAllAdminPackages.jsp").forward(request,response);
		}
			
			
    %>
      


</body>
</html>