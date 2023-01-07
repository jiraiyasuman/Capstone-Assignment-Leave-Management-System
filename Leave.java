package com.AxisBank.LeaveManagementSystem.entity;
/**
 * Description: This is an entity class of the leaves allotted to the employees by the company
 * Author: Suman Talukdar
 * Version: 1.0 
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter

public class Leave {
	private String id;
	private int sick;
	private int casual;
	private int personal;
	private int  maternity;
	private int paternity;
	private int adoption;
	private int marriage;
	
	public Leave() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSick() {
		return sick;
	}

	public void setSick(int sick) {
		this.sick = sick;
	}

	public int getCasual() {
		return casual;
	}

	public void setCasual(int casual) {
		this.casual = casual;
	}

	public int getPersonal() {
		return personal;
	}

	public void setPersonal(int personal) {
		this.personal = personal;
	}

	public int getMaternity() {
		return maternity;
	}

	public void setMaternity(int maternity) {
		this.maternity = maternity;
	}

	public int getPaternity() {
		return paternity;
	}

	public void setPaternity(int paternity) {
		this.paternity = paternity;
	}

	public int getAdoption() {
		return adoption;
	}

	public void setAdoption(int adoption) {
		this.adoption = adoption;
	}

	public int getMarriage() {
		return marriage;
	}

	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}

	public Leave(String id, int sick, int casual, int personal, int maternity, int paternity, int adoption,
			int marriage) {
		super();
		this.id = id;
		this.sick = sick;
		this.casual = casual;
		this.personal = personal;
		this.maternity = maternity;
		this.paternity = paternity;
		this.adoption = adoption;
		this.marriage = marriage;
	}
	
}
