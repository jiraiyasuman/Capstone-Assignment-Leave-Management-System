package com.AxisBank.LeaveManagementSystem.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagementSystem.entity.Leave;
import com.AxisBank.LeaveManagementSystem.repository.LeaveRepository;
import com.AxisBank.LeaveManagementSystem.util.LeaveUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/LeaveController")
public class LeaveController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		try {
			String id=req.getParameter("id");
			int sick=Integer.parseInt(req.getParameter("sick"));
			int casual=Integer.parseInt(req.getParameter("casual"));
			int personal=Integer.parseInt(req.getParameter("personal"));
			int maternity=Integer.parseInt(req.getParameter("maternity"));
			int paternity=Integer.parseInt(req.getParameter("paternity"));
			int adoption=Integer.parseInt(req.getParameter("adoption"));
			int marriage=Integer.parseInt(req.getParameter("marriage"));
			Leave l=new Leave( id, sick, casual, personal,  maternity,  paternity,  adoption,
					 marriage);
			LeaveRepository lr=LeaveUtil.getObject();
			boolean f=lr.insert(l);
			if(f==true) {
				session.setAttribute("successMessage18","Leave Balance is successfully inserted !");
				resp.sendRedirect("view/allot.jsp");
			}else {
				session.setAttribute("errorMessage18", "Leave Balance is not successfully inserted !");
				 resp.sendRedirect("view/allot.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
