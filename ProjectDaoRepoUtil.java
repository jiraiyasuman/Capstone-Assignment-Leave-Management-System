package com.AxisBank.LeaveManagementSystem.util;


import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ProjectDaoRepoUtil {
	public static ProjectDaoRepo getObject()
	{
		try {
			return new ProjectService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
