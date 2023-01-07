package com.AxisBank.LeaveManagementSystem.service;

import java.sql.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.HolidayList;
import com.AxisBank.LeaveManagementSystem.repository.HolidayListRepository;

public class HolidayListService implements HolidayListRepository {

	public Connection conn;
	public HolidayList hl=null;
	public HolidayListService(Connection c) {
		this.conn=conn;
	}

	@Override
	public boolean addHoliday(HolidayList h) {
		boolean f=false;
		try {
			String sql="INSERT INTO `leavemanagementsystem`.`holidaylist` (`Day`, `Date`, `Holiday name`, `Holiday type`, `Year`) VALUES (?, ?, ?, ?,?);";
			 conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, h.getDay());
				ps.setString(2, h.getDate());
				ps.setString(3, h.getName());
				ps.setString(4, h.getType());
				ps.setString(5, h.getYear());
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
