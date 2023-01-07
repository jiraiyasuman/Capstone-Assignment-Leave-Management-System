package com.AxisBank.LeaveManagementSystem.util;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

import com.AxisBank.LeaveManagementSystem.repository.HolidayListRepository;
import com.AxisBank.LeaveManagementSystem.service.*;

public class HolidayListUtil {

	public static HolidayListRepository getObject() {
		try {
			return new HolidayListService(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
