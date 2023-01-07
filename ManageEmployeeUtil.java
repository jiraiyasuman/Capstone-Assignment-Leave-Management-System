package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.repository.ManageManagerDaoRepo;
import com.AxisBank.LeaveManagementSystem.service.*;

public class ManageEmployeeUtil {

	public static ManageManagerDaoRepo getObject() {
		try {
			return new ManageManagerService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
