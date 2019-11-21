package com.classmarker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StudentDAO {
	public static boolean addstudent(String userenrollment,
			String userid,String contact,String email,String pwd,
			String selectedbranch,String selectedsemester) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap,pstmtmaprole = null;
		con = CommonDAO.getConnection();
		System.out.println("Before Running update Statement");
		pstmt = con.prepareStatement("insert into user_mst"
				+ "(userenrollment,userid,contact,email,password) "
				+ "values(?,?,?,?,?)");
		pstmt.setString(1, userenrollment);
		pstmt.setString(2,userid);
		pstmt.setString(3, contact);
		pstmt.setString(4, email);
		pstmt.setString(5,pwd);
		int recordcount = pstmt.executeUpdate();
		
		pstmtmaprole = con.prepareStatement("insert into user_role_mapping"
				+ "(userid,roleid) values((select uid from user_mst "
				+ "where userid=?),"
				+ "(select roleid from role_mst where rolename=?))");
		pstmtmaprole.setString(1, userid);
		pstmtmaprole.setString(2, "student");
		pstmtmaprole.executeUpdate();
		
		if(recordcount>0) {
			pstmtmap = con.prepareStatement("insert into "
					+ "userStudent_branch_semester_mapping"
					+ "(userid,branchid,semesterid) "
					+ "values((select uid from user_mst where userid=?),"
					+ "(select branchid from branch_mst where branchname=?),"
					+ "(select semid from semester_mst where semestername=?))");
			pstmtmap.setString(1, userid);
			pstmtmap.setString(2, selectedbranch);
			pstmtmap.setString(3, selectedsemester);
			int recordcountmap = pstmtmap.executeUpdate();
			System.out.println("New Student Added");
			if(recordcountmap>0) {
				return true;
			}
		}
		return false;
	}
	

}