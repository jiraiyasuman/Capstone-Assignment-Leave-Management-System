package com.AxisBank.LeaveManagementSystem.repository;

public interface LeaveBalanceRepo {
	public  void update(String id, String leaveType, int balance);
}
