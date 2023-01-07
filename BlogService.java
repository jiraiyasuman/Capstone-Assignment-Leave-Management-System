package com.AxisBank.LeaveManagementSystem.service;

import com.AxisBank.LeaveManagementSystem.entity.Blog;
import com.AxisBank.LeaveManagementSystem.repository.BlogRepository;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.*;
public class BlogService implements BlogRepository{
public Connection conn=null;
public Blog b=null;

	@Override
	public boolean addBlog(Blog b) {
		boolean f=false;
		try {
			String sql="INSERT INTO `leavemanagementsystem`.`blog` (`POST_DATE`, `ABOUT`) VALUES (?,?);";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, b.getDate());
			ps.setString(2, b.getAbout());
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

	public BlogService(Connection c) {
		super();
		this.conn = c;
	}

}
