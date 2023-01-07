package com.AxisBank.LeaveManagementSystem.controller;

import java.io.IOException;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/DeleteEmployeeController")
public class DeleteEmployeeController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		HttpSession session=req.getSession();
		try {
			NewEmployeeService n=new NewEmployeeService(DbConnect.getConnection());
			boolean hr=n.delete(id);
			if(hr==true)
			{
				session.setAttribute("successMessage17","Employee Record is successfully deleted !");
				resp.sendRedirect("view/delete.jsp");
			}
			else
			{
				session.setAttribute("errorMessage17", "Employee Record is not successfully deleted !");
				 resp.sendRedirect("view/delete.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
