package com.AxisBank.LeaveManagementSystem.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagementSystem.entity.HolidayList;
import com.AxisBank.LeaveManagementSystem.repository.HolidayListRepository;
import com.AxisBank.LeaveManagementSystem.util.HolidayListUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/HolidayListController")
public class HolidayListController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		try {
			String day=req.getParameter("day");
			String date=req.getParameter("date");
			String name=req.getParameter("name");
			String type=req.getParameter("type");
			String year=req.getParameter("year");
			HolidayList hl=new HolidayList( day,  date, type,  name, year);
			HolidayListRepository repo=HolidayListUtil.getObject();
			boolean b = repo.addHoliday(hl);
			if(b==true) {
				session.setAttribute("success", "Insertion successful");
				resp.sendRedirect("view/holidayList.jsp");
			}
			else {
				session.setAttribute("error", "Insertion not successful");
				resp.sendRedirect("view/holidayList.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
