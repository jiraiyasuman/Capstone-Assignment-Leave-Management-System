package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.repository.LeaveRepository;
import com.AxisBank.LeaveManagementSystem.service.LeaveService;

public class LeaveUtil {

	public static LeaveRepository getObject() {
		try {
			return new LeaveService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
