package com.AxisBank.LeaveManagementSystem.entity;
/**
 * Description: This is an entity class of the news posted by the HR
 * Author: Suman Talukdar
 * Version: 1.0 
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class Blog {

	private String date;
	private String about;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Blog(String date,String about) {
		this.date=date;
		this.about=about;
	}
}
