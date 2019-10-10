package com.classmarker.student.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.classmarker.dao.CommonDAO;
import com.classmarker.dto.RightsDTO;
import com.classmarker.dto.LandingDTO;

public class LandingStudent {
//	HttpSession session=ServletActionContext.getRequest().getSession(false);
//	String uniqueid = (String) session.getAttribute("uniqueid");
	private List<LandingDTO> lands;
	
	public List<LandingDTO> getLands() {
		return lands;
	}

	public void setLands(List<LandingDTO> lands) {
		this.lands = lands;
	}

	public String fetch() throws ClassNotFoundException, SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("");
		pstmt.setString(1,"1");
		rs = pstmt.executeQuery();
		if(rs.next()) {
			lands = new ArrayList<LandingDTO>();
		do{
				
			LandingDTO land = new LandingDTO(rs.getString("testname"),rs.getString("marksperquestion"),rs.getString("branchname"),rs.getString("groupname"),rs.getString("semestername"),rs.getString("subjectname"),rs.getString("userid"));
			lands.add(land);
		}while(rs.next());
			return "success";
		 }
		return "fail";
	}
}
