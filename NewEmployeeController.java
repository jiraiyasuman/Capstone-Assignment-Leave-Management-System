package com.AxisBank.LeaveManagementSystem.controller;

import java.io.IOException;
import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.util.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.*;
import com.AxisBank.LeaveManagementSystem.entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/NewEmployeeController")
public class NewEmployeeController extends HttpServlet{

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("fullName");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String phNumber=req.getParameter("phoneNumber");
		String role=req.getParameter("role");
		String reporting=req.getParameter("reporting");
		String reportingName=req.getParameter("reportingName");
		String reportingEmail=req.getParameter("reportingEmail");
		try {
			HttpSession session=req.getSession();
			int z=(int)Math.floor(Math.random()*(1000000-1+1)+1);
			String id="EMP"+Integer.toString(z);
			AddNewEmployee a= new AddNewEmployee(name,  gender,  email,phNumber, role,  id,
					 reporting,reportingName, reportingEmail);
			String message="Dear"+name+",\n We bid you welcome in our company. Your personal details have been taken into account. You will have to register in our login portal as a new user. Your user Id is your "
					+ " official email Id and your Password should be a strong password with atleast 7 characters containing atleast one UpperCase character, one lowercase character, one special character, and one digit. "
					+ " Thank you. ";
			String sub="New Employee Registration details";
			Emails.sendEmail( message,sub,email,"suman.talukdar53@gmail.com");
			NewEmployeeDaoRepo n= NewEmployeeDaoRepoUtil.getObject();
			boolean z1=n.insert(a);
			if(z1==true)
			{
				
				session.setAttribute("successMessage4","New Employee Addition is successful !");
				resp.sendRedirect("view/registration.jsp");
				
			}
			else
			{
				session.setAttribute("errorMessage4", "New Employee Addition is not successful !");
				resp.sendRedirect("view/registration.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
