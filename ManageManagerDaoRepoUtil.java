package com.AxisBank.LeaveManagementSystem.util;


import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManageManagerDaoRepoUtil {
	public static ManageManagerDaoRepo getObject()
	{
		try {
			return new ManageManagerService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
