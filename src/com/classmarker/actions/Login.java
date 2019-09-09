package com.classmarker.actions;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.classmarker.dao.ClassmarkerDAO;

public class Login {
	private String userid;
	private String password;
	private String message;
	@Override
	public String toString() {
		return "Login [userid=" + userid + ", password=" + password + 
				", message=" + message + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin() throws ClassNotFoundException, SQLException, NamingException {
		if (ClassmarkerDAO.login(userid, password)) {
			System.out.println("Inside dologin....");
			return "success";
		}
		System.out.println("Outside the function...");
		this.message = "Invalid";
		return "fail";
	}
}
