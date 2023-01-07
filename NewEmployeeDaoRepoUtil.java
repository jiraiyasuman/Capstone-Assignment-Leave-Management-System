package com.AxisBank.LeaveManagementSystem.util;


import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class NewEmployeeDaoRepoUtil {
	public static NewEmployeeDaoRepo getObject()
	{
		try {
			return new NewEmployeeService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
