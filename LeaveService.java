package com.AxisBank.LeaveManagementSystem.service;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.*;
import com.AxisBank.LeaveManagementSystem.repository.LeaveRepository;
public class LeaveService implements LeaveRepository {

	public Connection conn;
	public Leave l=null;
	public LeaveService(Connection conn) {
		super();
		this.conn = conn;
	}
	@Override
	public boolean insert(Leave l) {
		boolean f=false;
		try {
			conn=DbConnect.getConnection();
			String sql="INSERT INTO `leavemanagementsystem`.`leavebalance` (`EMPLOYEE_ID`, `SICK_LEAVE`, `CASUAL_LEAVE`, `PERSONAL_LEAVE`, `MATERNITY_LEAVE`, `PATERNITY_LEAVE`, `ADOPTION_LEAVE`, `MARRIAGE_LEAVE`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,l.getId());
			ps.setInt(2,l.getSick());
			ps.setInt(3,l.getCasual());
			ps.setInt(4,l.getPersonal());
			ps.setInt(5,l.getMaternity());
			ps.setInt(6,l.getPaternity());
			ps.setInt(7,l.getAdoption());
			ps.setInt(8, l.getMarriage());
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
