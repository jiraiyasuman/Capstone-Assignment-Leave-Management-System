package com.AxisBank.LeaveManagementSystem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
@WebServlet("/ManageHRController")
public class ManageHRController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String leaveType=req.getParameter("leaveType");
		String fromDate=req.getParameter("fromDate");
		String toDate=req.getParameter("toDate");
		String noOfDays=req.getParameter("noOfDays");
		String leaveReason=req.getParameter("leaveReason");
		String status=req.getParameter("status");
		int ab=Integer.parseInt(noOfDays);
		int b=0;int balance=0;
		String s=req.getParameter("leaveType");
		HttpSession session=req.getSession();
		if(leaveType.equalsIgnoreCase("Sick Leave"))
		{
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT SICK_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("Casual Leave"))
		{
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT CASUAL_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("Personal Leave"))
		{
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT PERSONAL_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("Maternity Leave")) {
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT MATERNITY_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("Paternity Leave")) {
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT PATERNITY_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("Marriage Leave")) {
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT MARRIAGE_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				Connection conn=DbConnect.getConnection();
				String sql="SELECT ADOPTION_LEAVE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					b=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String email="";String gender="";String reporting="";
		try {
			Connection conn=DbConnect.getConnection();
			String sql="SELECT Email,Gender,Reporting_Email FROM leavemanagementsystem.employeedetails WHERE EmployeeId=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				email=rs.getString(1);
				gender=rs.getString(2);
				reporting=rs.getString(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(status.equalsIgnoreCase("Approved"))
			{
				if(s.equalsIgnoreCase("Sick Leave")||s.equalsIgnoreCase("Casual Leave")||s.equalsIgnoreCase("Personal Leave")||s.equalsIgnoreCase("Marriage Leave"))
	            {
					balance=b-ab;
	            	if(balance>0)
	            	{
	            		if(ab<=15){
	            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
	            					leaveReason,balance, status,reporting);
	            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
	            			LeaveBalance leaveBalance = new LeaveBalance();
							leaveBalance.update(id, leaveType, balance);
	            			boolean f=h.insert(a);
	            			if(f==true)
	            			{
	            				String message=" your leave application has been"+status;
	            				String subject="Leave Application Status";
	            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
	            				session.setAttribute("successMessage3","Leave is managed successfully !");
	            				resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	            			else
	            			{
	            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
	            				 resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	    					}
	    					else
	                	{
	                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
	       				 resp.sendRedirect("view/myLeavesHR.jsp");
	                	}
	            	 }
	            	else
	            	{
	            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
	            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
	            {
	            	balance=b-ab;
	            	if(balance>0)
	            	{
	            		if(ab<=30){
	            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
	            					leaveReason,balance, status,reporting);
	            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
	            			LeaveBalance leaveBalance2 = new LeaveBalance();
							leaveBalance2.update(id, leaveType, balance);
	            			boolean f=h.insert(a);
	            			if(f==true)
	            			{
	            				String message=" your leave application has been"+status;
	            				String subject="Leave Application Status";
	            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
	            				session.setAttribute("successMessage3","Leave is managed successfully !");
	            				resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	            			else
	            			{
	            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
	            				 resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	    					}
	    					else
	                	{
	                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
	       				 resp.sendRedirect("view/myLeavesHR.jsp");
	                	}
	            	 }
	            	else
	            	{
	            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
	            else
	            {
	            	if(gender.equalsIgnoreCase("Female")||gender.equalsIgnoreCase("Transgender")) {
	            		balance=b-ab;
		            	if(balance>0)
		            	{
		            		if(ab<=180){
		            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
		            					leaveReason,balance, status,reporting);
		            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
		            			LeaveBalance leaveBalance3 = new LeaveBalance();
								leaveBalance3.update(id, leaveType, balance);
		            			boolean f=h.insert(a);
		            			if(f==true)
		            			{
		            				String message=" your leave application has been"+status;
		            				String subject="Leave Application Status";
		            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
		            				session.setAttribute("successMessage3","Leave is managed successfully !");
		            				resp.sendRedirect("view/myLeavesHR.jsp");
		            			}
		            			else
		            			{
		            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
		            				 resp.sendRedirect("view/myLeavesHR.jsp");
		            			}
		    					}
		    					else
		                	{
		                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
		       				 resp.sendRedirect("view/myLeavesHR.jsp");
		                	}
		            	 }
		            	else
		            	{
		            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
		      				 resp.sendRedirect("view/myLeavesHR.jsp");
		            	}
	            	}else {
	            		session.setAttribute("errorMessage3", " Males cannot apply for a Maternity Leave");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
			}
			else
			{
				if(s.equalsIgnoreCase("Sick Leave")||s.equalsIgnoreCase("Casual Leave")||s.equalsIgnoreCase("Personal Leave")||s.equalsIgnoreCase("Marriage Leave"))
	            {
					balance=b;
	            	if(balance>0)
	            	{
	            		if(ab<=15){
	            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
	            					leaveReason,balance, status,reporting);
	            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
	            			
	            			boolean f=h.insert(a);
	            			if(f==true)
	            			{
	            				String message=" your leave application has been"+status;
	            				String subject="Leave Application Status";
	            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
	            				session.setAttribute("successMessage3","Leave is managed successfully !");
	            				resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	            			else
	            			{
	            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
	            				 resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	    					}
	    					else
	                	{
	                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
	       				 resp.sendRedirect("view/myLeavesHR.jsp");
	                	}
	            	 }
	            	else
	            	{
	            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
	            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
	            {
	            	balance=b;
	            	if(balance>0)
	            	{
	            		if(ab<=30){
	            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
	            					leaveReason,balance, status,reporting);
	            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
	            			boolean f=h.insert(a);
	            			if(f==true)
	            			{
	            				String message=" your leave application has been"+status;
	            				String subject="Leave Application Status";
	            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
	            				session.setAttribute("successMessage3","Leave is managed successfully !");
	            				resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	            			else
	            			{
	            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
	            				 resp.sendRedirect("view/myLeavesHR.jsp");
	            			}
	    					}
	    					else
	                	{
	                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
	       				 resp.sendRedirect("view/myLeavesHR.jsp");
	                	}
	            	 }
	            	else
	            	{
	            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
	            else
	            {
	            	if(gender.equalsIgnoreCase("Female")||gender.equalsIgnoreCase("Transgender")) {
	            		balance=b;
		            	if(balance>0)
		            	{
		            		if(ab<=180){
		            			ManageHR a=new ManageHR(id, name, leaveType, fromDate, toDate, ab,
		            					leaveReason,balance, status,reporting);
		            			ManageHRDaoRepo h=ManageHRDaoRepoUtil.getObject();
		            			boolean f=h.insert(a);
		            			if(f==true)
		            			{
		            				String message=" your leave application has been"+status;
		            				String subject="Leave Application Status";
		            				Emails.sendEmail(message, subject,email, "suman.talukdar53@gmail.com");
		            				session.setAttribute("successMessage3","Leave is managed successfully !");
		            				resp.sendRedirect("view/myLeavesHR.jsp");
		            			}
		            			else
		            			{
		            				session.setAttribute("errorMessage3", "Leave is not managed successfully !");
		            				 resp.sendRedirect("view/myLeavesHR.jsp");
		            			}
		    					}
		    					else
		                	{
		                	 session.setAttribute("errorMessage3", " Number of days is greater than the allotted category !");
		       				 resp.sendRedirect("view/myLeavesHR.jsp");
		                	}
		            	 }
		            	else
		            	{
		            		session.setAttribute("errorMessage3", " Your leave Balance is negative !");
		      				 resp.sendRedirect("view/myLeavesHR.jsp");
		            	}
	            	}else {
	            		session.setAttribute("errorMessage3", " Males cannot apply for a Maternity Leave");
	      				 resp.sendRedirect("view/myLeavesHR.jsp");
	            	}
	            }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
