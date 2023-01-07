package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class HrLeaveDaoRepoUtil {

	public static HrLeaveDaoRepo getObject()
	{
		try {
			return new HrLeaveService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
