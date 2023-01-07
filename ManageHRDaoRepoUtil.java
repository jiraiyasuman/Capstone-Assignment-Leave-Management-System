package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManageHRDaoRepoUtil {

	public static ManageHRDaoRepo getObject()
	{
		try {
			return new ManageHRService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
