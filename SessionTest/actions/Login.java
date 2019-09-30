package com.classmarker.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.classmarker.dao.ClassmarkerDAO;
import com.classmarker.dao.CommonDAO;
import com.classmarker.dto.RightsDTO;

public class Login implements SessionAware {
	private String userid;
	private String password;
	private String rolename;
	private String message;
	private List<RightsDTO> rights;
	Map<String, Object> session;
	@Override
	public String toString() {
		return "Login [userid=" + userid + ", password=" + password + 
				", message=" + message + ", rights=" + rights
				+ "]";
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<RightsDTO> getRights() {
		return rights;
	}
	public void setRights(List<RightsDTO> rights) {
		this.rights = rights;
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("SELECT USER_MST.USERID AS USERID, "
				+ "ROLE_MST.ROLENAME AS ROLE,RIGHT_MST.RIGHTNAME,"
				+ "RIGHT_MST.LINK FROM USER_MST, ROLE_MST,RIGHT_MST "
				+ ",USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE "
				+ "USER_MST.UID=USER_ROLE_MAPPING.USERID AND "
				+ "ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID "
				+ "AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND "
				+ "RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID and "
				+ "USER_MST.USERID=? and PASSWORD=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			rights = new ArrayList<RightsDTO>();
		do{
			setRolename(rs.getString("role"));
			
			RightsDTO right = new RightsDTO(rs.getString("RIGHTNAME"), 
					rs.getString("link"));
			rights.add(right);
		}while(rs.next());
		session.put("role", rolename);
		session.put("userid", userid);
		session.put("rights", rights);
			 return "success";
		 }
		System.out.println("Outside the function...");
		this.message = "Invalid";
		return "fail";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		System.out.println("Inside Mapping Session");
		this.session = session;
	}
}
