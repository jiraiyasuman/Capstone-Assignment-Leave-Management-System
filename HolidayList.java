package com.AxisBank.LeaveManagementSystem.entity;
/**
 * Description: This is an entity class of the Yearly holidays provided by the company
 * Author: Suman Talukdar
 * Version: 1.0 
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class HolidayList {

	private String day;
	private String date;
	private String type;
	private String name;
	private String year;
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public HolidayList(String day, String date, String type, String name, String year) {
		super();
		this.day = day;
		this.date = date;
		this.type = type;
		this.name = name;
		this.year = year;
	}
	
}
