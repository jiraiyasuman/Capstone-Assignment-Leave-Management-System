package com.AxisBank.LeaveManagementSystem.repository;

import com.AxisBank.LeaveManagementSystem.entity.ManageManager;

public interface ManageManagerDaoRepo {
	public boolean insert(ManageManager m) throws Exception;
	public boolean insertHr(ManageManager m)throws Exception;
}
