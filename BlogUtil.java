package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.repository.BlogRepository;
import com.AxisBank.LeaveManagementSystem.service.BlogService;

public class BlogUtil {

	public static BlogRepository getObject() {
		try {
			return new BlogService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
