package com.AxisBank.LeaveManagementSystem.controller;
import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagementSystem.entity.Login;
import com.AxisBank.LeaveManagementSystem.repository.LoginRepository;
import com.AxisBank.LeaveManagementSystem.util.LoginUtil;
import com.AxisBank.LeaveManagementSystem.databaseConnection.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
@MultipartConfig
@SuppressWarnings("serial")
@WebServlet("/LoginController")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		boolean f=false;
		Part p=null;String password1="";String name="";String email="";String fileName="";String password="";String mobile="";String role="";String otp="";String message="";String sub="";
		switch(action)
		{
		case "register":
			try {
				p = req.getPart("files");
				 fileName = p.getSubmittedFileName();
				name=req.getParameter("name");
				email=req.getParameter("email");
				password=req.getParameter("password");
				 password1=Cipher.encryption(password);
				mobile=req.getParameter("mobile");
				role=req.getParameter("role");
				otp="BLKSEC"+String.valueOf((int)Math.floor(Math.random()*((999999-1)+1))); 
				Login l=new Login(fileName, name, password1, mobile, role, email, otp);
				LoginRepository lr=LoginUtil.getObject();
				f=lr.addUser(l);
				if(f==true)
				{
					String path = getServletContext().getRealPath("") + "userImgs";
					  File file1 = new File(path);
					  
					  p.write(path + File.separator + fileName);
					session.setAttribute("successMessage", "Registration is done successfully");
					resp.sendRedirect("view/register.jsp");
				}else {
					session.setAttribute("errorMessage", "Registration is not done successfully");
					resp.sendRedirect("view/register.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "login":
            try {
            	email=req.getParameter("email");
				password=req.getParameter("password");
				password1=Cipher.encryption(password);
				otp="BLKSEC"+String.valueOf((int)Math.floor(Math.random()*((999999-1)+1))); 
				 message="OTP  "+otp;
				 sub="Otp Login";
				Emails.sendEmail(message, sub, email, "suman.talukdar53@gmail.com");
				Login l1=new Login(email,password1);
				LoginRepository lr1=LoginUtil.getObject();
				f=lr1.updateOtp(email, otp);
				f=lr1.checkUser(l1);
				if(f==true) {
					session.setAttribute("successMessage1", "Login is done successfully");
					resp.sendRedirect("view/otp.jsp");
				}else {
					session.setAttribute("errorMessage1", "Login is not done successfully");
					resp.sendRedirect("view/login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "otp":
            try {
            	email=req.getParameter("email");
				otp=req.getParameter("otp");
				role=req.getParameter("role");
				Login l2=new Login(role, email,  otp);
				LoginRepository lr2 = LoginUtil.getObject();
				f=lr2.checkOtp(l2);
				if(f==true) {
					if(role.equalsIgnoreCase("Human Resources")) {
						session.setAttribute("msg", email);
						resp.sendRedirect("view/homeHR.jsp");
					}else if(role.equalsIgnoreCase("Employee")) {
						session.setAttribute("msg", email);
						resp.sendRedirect("view/homeemployee.jsp");
					}else {
						session.setAttribute("msg", email);
						resp.sendRedirect("view/homeManager.jsp");
					}
				}else {
					session.setAttribute("errorMessage1", "Oops ! Error occured");
					resp.sendRedirect("view/login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "updatePassword":
             try {
            	 email=req.getParameter("email");
            	 password=req.getParameter("password");
            	 String confirmpassword=req.getParameter("confirmpassword");
            	 if(password.equals(confirmpassword))
            	 {
            		 password1=Cipher.encryption(password);
            		 LoginRepository lr2 = LoginUtil.getObject();
            		 f=lr2.updatePassword(email,password);
            		 if(f==true) {
            			 session.setAttribute("successMessage7", "Password is updated");
      					resp.sendRedirect("view/pc.jsp");
            		 }else {
            			 session.setAttribute("errorMessage7", "Password is not updated");
      					resp.sendRedirect("view/pc.jsp");
            		 }
            		 
            	 }else {
            		 session.setAttribute("errorMessage7", "New Password and confirmed password do not match");
 					resp.sendRedirect("view/pc.jsp");
            	 }
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "forgotPassword":
			try {
				email=req.getParameter("email");
				String sql="SELECT PASSWORD FROM `leavemanagementsystem`.`login` WHERE EMAIL=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				while(rs!=null) {
					password=rs.getString(1);
				}
				password1=Cipher.decryption(password);
				 message="Your Password "+password1;
				 sub="User Password";
				Emails.sendEmail(message, sub, email, "suman.talukdar53@gmail.com");
				resp.sendRedirect("views/login.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			default:
				System.out.println("Wrong choice");
		}
	}

}
