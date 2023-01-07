package com.AxisBank.LeaveManagementSystem.service;

import java.io.File;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.Login;
import com.AxisBank.LeaveManagementSystem.repository.LoginRepository;

import jakarta.servlet.annotation.MultipartConfig;
@MultipartConfig
public class LoginService implements LoginRepository{

	public Connection conn=null;
	public Login l=null;
	public LoginService(Connection c) {
		this.conn=c;
	}

	@Override
	public boolean addUser(Login l) // registration functionality
	{
		boolean f=false;
		try {
			String sql="INSERT INTO `leavemanagementsystem`.`login` (`FILE`,`NAME`, `PASSWORD`, `MOBILE`, `ROLE`, `EMAIL`, `OTP`) VALUES (?,?, ?, ?, ?, ?, ?);";
			conn = DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, l.getFile());
			ps.setString(2, l.getName());
			ps.setString(3, l.getPassword());
			ps.setString(4,l.getMob());
			ps.setString(5, l.getRole());
			ps.setString(6, l.getEmail());
			ps.setString(7, l.getOtp());
			int z=ps.executeUpdate();
			if(z>0) {
				f=true;
			
			}
			else {
				f=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkUser(Login l) // login functionality
	{
		boolean f=false;
		try {
			String sql="SELECT * FROM `leavemanagementsystem`.`login` WHERE EMAIL=? AND PASSWORD=?";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, l.getEmail());
			ps.setString(2, l.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				l=new Login();
				l.setEmail(rs.getString(1));
				l.setPassword(rs.getString(2));
			}
			if(l!=null) {
				f=true;
			}
			else {
				f=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean checkOtp(Login l) // OTP verification
	{
		boolean f=false;
		try {
			String sql="SELECT * FROM `leavemanagementsystem`.`login` WHERE EMAIL=? AND OTP=?;";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, l.getEmail());
			
			ps.setString(2, l.getOtp());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				l=new Login();
				l.setEmail(rs.getString(1));
				
				l.setOtp(rs.getString(2));
			}
			if(l!=null) {
				f=true;
			}
			else {
				f=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updatePassword(String email, String password)  // update password
	{
		boolean f=false;
		try {
			String sql="UPDATE `leavemanagementsystem`.`login` SET PASSWORD=? WHERE EMAIL=?";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			int z=ps.executeUpdate();
			if(z>0) {
				f=true;
			}else {
				f=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateOtp(String email, String otp) {
		boolean f=false;
		try {
			String sql="UPDATE `leavemanagementsystem`.`login` SET OTP=? WHERE EMAIL=?";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, otp);
			ps.setString(2, email);
			int z=ps.executeUpdate();
			if(z>0) {
				f=true;
			}else {
				f=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
