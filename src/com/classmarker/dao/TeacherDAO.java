package com.classmarker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface TeacherDAO {
	public static boolean addteacher(String userenrollment,String userid,
			String contact,String email,String pwd,
			String selectedbranch,String selectedsemester,
			String selectedsubject) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
		String regex=",";
	    String[] branches=selectedbranch.split(regex);
	    String[] semesters=selectedsemester.split(regex);
	    String[] subjects=selectedsubject.split(regex);
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
		if(recordcount>0) {
			for(String branchstr : branches)
		    {
				for(String semesterstr : semesters)
			    {
					for(String subjectstr : subjects)
				    {
					
			pstmtmap = con.prepareStatement("insert into "
					+ "userteacher_branch_semester_subject_mapping"
					+ "(userid,branchid,semesterid,subjectid) "
					+ "values((select uid from user_mst where userid=?),"
					+ "(select branchid from branch_mst where branchname=?),"
					+ "(select semid from semester_mst where semestername=?),"
					+ "(select sid from subject_mst where subjectname=?))");
			pstmtmap.setString(1, userid);
			pstmtmap.setString(2, branchstr.trim());
			pstmtmap.setString(3, semesterstr.trim());
			pstmtmap.setString(4, subjectstr.trim());
			int recordcountmap = pstmtmap.executeUpdate();
				    }
			    }
		    }
			System.out.println("New Teacher Added");
			return true;
		}
		return false;
	}
}
