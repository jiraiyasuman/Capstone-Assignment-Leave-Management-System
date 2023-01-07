package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.repository.*;
import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class LeaveBalanceRepoUtil {
	public static LeaveBalanceRepo getObject()
	{
		try {
			return new LeaveBalance(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
