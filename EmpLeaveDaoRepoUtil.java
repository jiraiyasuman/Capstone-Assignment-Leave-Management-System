package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.repository.*;

import com.AxisBank.LeaveManagementSystem.service.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class EmpLeaveDaoRepoUtil {
	public static EmpLeaveDaoRepo getObject()
	{
		try {
			return new EmpLeaveService(DbConnect.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
