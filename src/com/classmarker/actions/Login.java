package com.classmarker.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.classmarker.dao.ClassmarkerDAO;
import com.classmarker.dao.CommonDAO;

public class Login {
	private String userid;
	private String rolename;
	private String password;
	private String message;
	private List<rightsDTO> rights;
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
	
//	public static boolean login(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
////		String msg ="Invalid Userid or Password";
//		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("select userid,password from user_mst where userid=? and password=?");
////		pstmt = con.prepareStatement("select userid, password "
////				+ "from user_mst where userid=? and password=?");
//		pstmt.setString(1, userid);
//		pstmt.setString(2, password);
//		rs = pstmt.executeQuery();
//		System.out.println(pstmt);
//		System.out.println(rs);
//		if(rs.next()){
//			 return true;
//		 }
////		if(rs.next()) {
//////			msg = "Welcome "+userid;
////			System.out.println("Login successful");
////			return true;
////		}
////		 return false;
////		 return userDTO;
//		 return false;
//	}
	
	public String doLogin() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("SELECT USER_MST.USERID AS USERID, ROLE_MST.ROLENAME AS ROLE,RIGHT_MST.RIGHTNAME,RIGHT_MST.LINK FROM USER_MST, ROLE_MST,RIGHT_MST "
				+ ",USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.USERID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID "
				+ "AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID and USER_MST.USERID=? and PASSWORD=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			rights = new ArrayList<rightsDTO>();
		while(rs.next()) {
			setRolename(rs.getString("role"));
			
			rightsDTO right = new rightsDTO(rs.getString("RIGHTNAME"), rs.getString("link"));
			rights.add(right);
//			return "success";
		}
//		if(rs.next()){
			 return "success";
		 }
//		if (ClassmarkerDAO.login(userid, password)) {
//			System.out.println("Inside dologin....");
//			return "success";
//		}
		System.out.println("Outside the function...");
		this.message = "Invalid";
		return "fail";
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<rightsDTO> getRights() {
		return rights;
	}
	public void setRights(List<rightsDTO> rights) {
		this.rights = rights;
	}
	
}
