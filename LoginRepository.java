package com.AxisBank.LeaveManagementSystem.repository;

import com.AxisBank.LeaveManagementSystem.entity.Login;

public interface LoginRepository {

	public boolean addUser(Login l);
	public boolean checkUser(Login l);
	public boolean checkOtp(Login l);

	public boolean updatePassword(String email,String password);
	public boolean updateOtp(String email,String otp);
}
