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
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String fromDate=req.getParameter("fromDate");
		String toDate=req.getParameter("toDate");
		String description=req.getParameter("description");
		try {
			HttpSession session=req.getSession();
			Project p=new Project(name,fromDate,toDate,description);
			ProjectDaoRepo pd=ProjectDaoRepoUtil.getObject();
			boolean f=pd.insert(p);
			if(f==true)
			{
				session.setAttribute("successMessage","New project details is successfully added !");
				resp.sendRedirect("view/project.jsp");
			}
			else
			{
				session.setAttribute("errorMessage", "New project details is not successfully added !");
				resp.sendRedirect("view/project.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
