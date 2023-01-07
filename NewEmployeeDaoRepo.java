package com.AxisBank.LeaveManagementSystem.repository;

import com.AxisBank.LeaveManagementSystem.entity.AddNewEmployee;

public interface NewEmployeeDaoRepo {

	public boolean insert(AddNewEmployee a)throws Exception;
	public boolean delete(String id);
}
