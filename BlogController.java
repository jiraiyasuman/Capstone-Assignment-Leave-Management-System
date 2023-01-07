package com.AxisBank.LeaveManagementSystem.controller;
import java.io.IOException;
import com.AxisBank.LeaveManagementSystem.entity.Blog;
import com.AxisBank.LeaveManagementSystem.repository.BlogRepository;
import com.AxisBank.LeaveManagementSystem.util.BlogUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/BlogController")
public class BlogController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String date=req.getParameter("date");
		String about=req.getParameter("about");
		try {
			Blog b=new Blog(date,about);
			BlogRepository br=BlogUtil.getObject();
			boolean f=br.addBlog(b);
			if(f==true) {
				session.setAttribute("success","News Posted Successfully");
				resp.sendRedirect("view/homeHR.jsp");
			}else {
				session.setAttribute("error","News Posted is not Successfully");
				resp.sendRedirect("view/homeHR.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
