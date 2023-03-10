package com.AxisBank.LeaveManagementSystem.entity;
/**
 * Description: This is an entity class of the leaves applied by the employees
 * Author: Suman Talukdar
 * Version: 1.0 
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name="finalleaverecordemployees")
public class ApplyLeaveEmployee {
	@Id
private String id;
	@Column(name="NAME",nullable=false)
private String name;
	@Column(name="FROM_DATE",nullable=false)
private String fromDate;
	@Column(name="TO_DATE",nullable=false)
private String toDate;
	@Column(name="LEAVE_TYPE",nullable=false)
private String leaveType;
	@Column(name="NO_OF_DAYS",nullable=false)
private int noOfDays;
	@Column(name="LEAVE_REASON",nullable=false)
private String leaveReason;
	@Column(name="BALANCE",nullable=false)
private int balance;
	@Column(name="STATUS",nullable=false)
private String status;
	@Column(name="REPORTING_EMAIL",nullable=false)
	private String email;
	
public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getFromDate() {
	return fromDate;
}

public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}

public String getToDate() {
	return toDate;
}

public void setToDate(String toDate) {
	this.toDate = toDate;
}

public String getLeaveType() {
	return leaveType;
}

public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}

public int getNoOfDays() {
	return noOfDays;
}

public void setNoOfDays(int noOfDays) {
	this.noOfDays = noOfDays;
}

public String getLeaveReason() {
	return leaveReason;
}

public void setLeaveReason(String leaveReason) {
	this.leaveReason = leaveReason;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public ApplyLeaveEmployee(String id, String name, String fromDate, String toDate, String leaveType, int noOfDays,
		String leaveReason, int balance, String status,String email) {
	super();
	this.id = id;
	this.name = name;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.leaveType = leaveType;
	this.noOfDays = noOfDays;
	this.leaveReason = leaveReason;
	this.balance = balance;
	this.status = status;
	this.email=email;
}
}
