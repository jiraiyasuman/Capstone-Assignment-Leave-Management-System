package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.repository.LoginRepository;
import com.AxisBank.LeaveManagementSystem.service.LoginService;

public class LoginUtil {

	public static LoginRepository getObject()
	{
		try {
			return new LoginService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
