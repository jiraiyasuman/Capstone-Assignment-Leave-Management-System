package com.AxisBank.LeaveManagementSystem.entity;
/**
 * Description: This is an entity class of the login portal
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

@Getter@Setter
@Entity
@Table(name="login")
public class Login {
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="FILE",nullable=false)
	private String file;
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Column(name="NAME",nullable=false)
	private String name;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	@Column(name="MOBILE",nullable=false)
	private String mob;
	@Column(name="ROLE",nullable=false)
	private String role;
	@Id
	private String email;
	@Column(name="OTP",nullable=false)
	private String otp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Login( String file,String name, String password, String mob, String role, String email, String otp) {
		super();
		this.file=file;
		this.name = name;
		this.password = password;
		this.mob = mob;
		this.role = role;
		this.email = email;
		this.otp = otp;
	}
	public Login(String name, String mob, String role, String email) {
		super();
		
		this.mob = mob;
		this.role = role;
		this.email = email;
		this.name=name;
	}
	public Login(String role, String email, String otp) {
		super();
		this.role = role;
		this.email = email;
		this.otp = otp;
	}
	public Login(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	
}
