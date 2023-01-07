package com.AxisBank.LeaveManagementSystem.util;


import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManagerLeaveDaoRepoUtil {
	public static ManagerLeaveDaoRepo getObject()
	{
		try {
			return new ManagerLeaveService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
