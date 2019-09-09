package com.classmarker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.classmarker.admin.actions.Branch;
import com.classmarker.dao.CommonDAO;

public interface ClassmarkerDAO {

	public static boolean startupstatus() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select status from app_startup where user_time=\"First Time\" and status =?");
		pstmt.setString(1, "Y");
		rs = pstmt.executeQuery();
		if(rs.next()) {
			
				System.out.println("Status Y is checked");
				return true;
		}
//		System.out.println(rs);
		rs.close();
		pstmt.close();
		con.close();
		System.out.println("Status N is checked");
		return false;
	}
	public static boolean firstlogin(String userid,String password) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select userid,password from user_mst where userid=? and password=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			
				System.out.println("userid check");
				return true;
		}
//		System.out.println(rs);
		rs.close();
		pstmt.close();
		con.close();
		return false;
		}
	
	public static boolean firstupdatepwd(String userid,String contact,String email,String pwd) throws ClassNotFoundException, SQLException {
		try {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int p = 0;
		con = CommonDAO.getConnection();
		System.out.println("Before Running update Statement");
		pstmt = con.prepareStatement(" update user_mst set userid=?, contact=?, email=? , password=? where uid=1");
		pstmt.setString(1,userid);
		pstmt.setString(2, contact);
		pstmt.setString(3, email);
		pstmt.setString(4,pwd);
		pstmt.executeUpdate();
//		rs = pstmt.executeQuery();
		System.out.println("After executing update statement");
//		if(rs.next()) {
//			System.out.println("Update successful");
//			return true;
//		}
//		rs.close();
//		System.out.println(p);
//		if(p!=0) {
//			System.out.println(p);
//			return true;
//		}
		pstmt.close();
		con.close();
		return true;
		}catch(Exception e) {
			System.out.println("Got an exception "+e.getMessage());
		
		return false;
	}
	}
	
	public static boolean startupfinish() throws ClassNotFoundException, SQLException {
		try {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("update app_startup set status=? where user_time=\"First Time\"");
		pstmt.setString(1, "N");
		pstmt.executeUpdate();
//		if(rs.next()) {
			System.out.println("Status N is checked");
//			return true;
//		}
//		System.out.println(rs);
//		rs.close();
		pstmt.close();
		con.close();
		return true;
		}catch(Exception e) {
			System.out.println("Got an exception "+e.getMessage());
			return false;
			}
		}
	
	public static boolean login(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select userid,password from user_mst where userid=? and password=?");
//		pstmt = con.prepareStatement("select userid, password "
//				+ "from user_mst where userid=? and password=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		System.out.println(rs);
		if(rs.next()){
			 return true;
		 }
//		if(rs.next()) {
////			msg = "Welcome "+userid;
//			System.out.println("Login successful");
//			return true;
//		}
//		 return false;
//		 return userDTO;
		 return false;
	}
	
	public static boolean addsub(String subjectcode,int subjectid,String subjectname,String subjectdesc,String selectedbranch,String selectedsemester) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
//		ResultSet rs,rsmap = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into subject_mst(subjectcode,subjectid,subjectname,subjectdesc) values(?,?,?,?)");
		pstmt.setString(1, subjectcode);
		pstmt.setInt(2, subjectid);
		pstmt.setString(3, subjectname);
		pstmt.setString(4, subjectdesc);
		int recordCount = pstmt.executeUpdate();
		pstmtmap = con.prepareStatement("insert into subject_branch_semester_mapping(subjectid,branchid,semesterid) values((select sid from subject_mst where subjectname=?),(select branchid from branch_mst where branchname=?),(select semid from semester_mst where semestername=?))");
		pstmtmap.setString(1, subjectname);
		pstmtmap.setString(2, selectedbranch);
		pstmtmap.setString(3, selectedsemester);
		int recordcountmap = pstmtmap.executeUpdate();
		if(recordCount>0) {
			if(recordcountmap>0) {
				System.out.println("Subject Added");
				return true;
			}
		}
		return false;
	}
	
	public static boolean addsem(String semestername,String semesterdesc) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into semester_mst(semestername,semesterdesc) values(?,?)");
		pstmt.setString(1, semestername);
		pstmt.setString(2, semesterdesc);
		int recordCount = pstmt.executeUpdate();
		if(recordCount>0) {
			System.out.println("Semester Added");
			return true;
		}
		return false;
	}
	
	public static boolean addbranch(String branchname,String branchdesc) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into branch_mst(branchname,branchdesc) values(?,?)");
		pstmt.setString(1, branchname);
		pstmt.setString(2, branchdesc);
		int recordCount = pstmt.executeUpdate();
		if(recordCount>0) {
			System.out.println("Branch Added");
			return true;
		}
		return false;
	}
	
	public static boolean addrole(String rolename,String roledesc, String selectedright) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
		String regex=",";
	    String[] rights=selectedright.split(regex);
		
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into role_mst(rolename,roledesc) values(?,?)");
		pstmt.setString(1, rolename);
		pstmt.setString(2, roledesc);
		int recordCount = pstmt.executeUpdate();
//		System.out.println(selectedright);
		if(recordCount>0) {
			for(String str : rights)
		    {
				pstmtmap = con.prepareStatement("insert into role_right_mapping(roleid,rightid) values((select roleid from role_mst where rolename=?),(select rightid from right_mst where rightname=?))");
				pstmtmap.setString(1, rolename);
				pstmtmap.setString(2, str.trim());
				int recordcount1 = pstmtmap.executeUpdate();
		    	System.out.println(str.trim());
		    }
			System.out.println("Role Added");
			return true;
		}
		return false;
	}
	
	

	public static boolean addstudent(String userenrollment,String userid,String contact,String email,String pwd,String selectedbranch,String selectedsemester) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
//		ResultSet rs = null;
		con = CommonDAO.getConnection();
		System.out.println("Before Running update Statement");
		pstmt = con.prepareStatement("insert into user_mst(userenrollment,userid,contact,email,password) values(?,?,?,?,?)");
		pstmt.setString(1, userenrollment);
		pstmt.setString(2,userid);
		pstmt.setString(3, contact);
		pstmt.setString(4, email);
		pstmt.setString(5,pwd);
		int recordcount = pstmt.executeUpdate();
		if(recordcount>0) {
			pstmtmap = con.prepareStatement("insert into user_branch_semester_mapping(userid,branchid,semesterid) values((select uid from user_mst where userid=?),(select branchid from branch_mst where branchname=?),(select semid from semester_mst where semestername=?))");
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
	
	public static boolean addteacher(String userenrollment,String userid,String contact,String email,String pwd,String selectedbranch,String selectedsemester,String selectedsubject) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
//		ResultSet rs = null;
		String regex=",";
	    String[] branches=selectedbranch.split(regex);
	    String[] semesters=selectedsemester.split(regex);
	    String[] subjects=selectedsubject.split(regex);
		con = CommonDAO.getConnection();
		System.out.println("Before Running update Statement");
		pstmt = con.prepareStatement("insert into user_mst(userenrollment,userid,contact,email,password) values(?,?,?,?,?)");
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
					
			pstmtmap = con.prepareStatement("insert into userteacher_branch_semester_subject_mapping(userid,branchid,semesterid,subjectid) values((select uid from user_mst where userid=?),(select branchid from branch_mst where branchname=?),(select semid from semester_mst where semestername=?),(select sid from subject_mst where subjectname=?))");
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
	
	public static boolean addgroup(String groupname,String groupdesc, String selectedstudent) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
		String regex=",";
	    String[] students=selectedstudent.split(regex);
		
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into group_mst(groupname,groupdesc) values(?,?)");
		pstmt.setString(1, groupname);
		pstmt.setString(2, groupdesc);
		int recordCount = pstmt.executeUpdate();
//		System.out.println(selectedright);
		if(recordCount>0) {
			for(String str : students)
		    {
				pstmtmap = con.prepareStatement("insert into group_student_mapping(groupid,studentid) values((select groupid from group_mst where groupname=?),(select uid from user_mst where userid=?))");
				pstmtmap.setString(1, groupname);
				pstmtmap.setString(2, str.trim());
				int recordcount1 = pstmtmap.executeUpdate();
		    	System.out.println(str.trim());
		    }
			System.out.println("Group Added");
			return true;
		}
		return false;
	}
	
	public static boolean addtest(String testname,String marksperquestion,String question,String choice1,String choice2,String choice3,String choice4,String selectedcorrectchoice,String selectedbranch,String selectedsemester,String selectedsubject,String selectedgroup) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt,pstmt1,pstmt2,pstmt3,pstmtmap = null;
		String regex=",";
	    String[] questions=question.split(regex);
	    String[] choices1=choice1.split(regex);
	    String[] choices2=choice2.split(regex);
	    String[] choices3=choice3.split(regex);
	    String[] choices4=choice4.split(regex);
	    String[] correctchoices=selectedcorrectchoice.split(regex);
	    String[] groups=selectedgroup.split(regex);
	    
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into test_mst(testname,marksperquestion) values(?,?)");
		pstmt.setString(1, testname);
		pstmt.setString(2, marksperquestion);
		int recordCount = pstmt.executeUpdate();
		for(int i=0;i<questions.length;i++) {
			pstmt1 = con.prepareStatement("insert into question_mst(questionname,choice1,choice2,choice3,choice4,correctchoice) values(?,?,?,?,?,?)");
			pstmt1.setString(1, questions[i].trim());
			pstmt1.setString(2, choices1[i].trim());
			pstmt1.setString(3, choices2[i].trim());
			pstmt1.setString(4, choices3[i].trim());
			pstmt1.setString(5, choices4[i].trim());
			pstmt1.setString(6, correctchoices[i].trim());
			int recordCount1 = pstmt1.executeUpdate();
		
		}
//		for(String questionstr : questions) {
//			for(String choice1str : choices1) {
//				for(String choice2str : choices2) {
//					for(String choice3str : choices3) {
//						for(String choice4str : choices4) {
//							
//								pstmt1 = con.prepareStatement("insert into question_mst(questionname,choice1,choice2,choice3,choice4,correctchoice) values(?,?,?,?,?,?)");
//								pstmt1.setString(1, questionstr.trim());
//								pstmt1.setString(2, choice1str.trim());
//								pstmt1.setString(3, choice2str.trim());
//								pstmt1.setString(4, choice3str.trim());
//								pstmt1.setString(5, choice4str.trim());
//								pstmt1.setString(6, correctchoicestr.trim());
//								int recordCount1 = pstmt1.executeUpdate();
//							
//						}
//					}
//				}
//			}
//		}
		if(recordCount>0) {
			for(int i=0;i<questions.length;i++) {
				pstmt2 = con.prepareStatement("insert into test_question_mapping(testid,questionid) values((select testid from test_mst where testname=?),(select questionid from question_mst where questionname=?))");
				pstmt2.setString(1, testname);
				pstmt2.setString(2, questions[i].trim());
				int recordCount2 = pstmt2.executeUpdate();
			}
			for(int i=0;i<groups.length;i++) {
				pstmt3 = con.prepareStatement("insert into test_branch_semester_subject_group_mapping(testid,branchid,semesterid,subjectid,groupid) values((select testid from test_mst where testname=?),(select branchid from branch_mst where branchname=?),(select semid from semester_mst where semestername=?),(select subjectid from subject_mst where subjectname=?),(select groupid from group_mst where groupname=?))");
				pstmt3.setString(1, testname);
				pstmt3.setString(2, selectedbranch);
				pstmt3.setString(3, selectedsemester);
				pstmt3.setString(4, selectedsubject);
				pstmt3.setString(5, groups[i].trim());
				int recordcount3 = pstmt3.executeUpdate();
			}
		
							

		System.out.println(testname);
		System.out.println(marksperquestion);
		System.out.println(question);
		System.out.println(choice1+choice2+choice3+choice4);
		System.out.println(selectedcorrectchoice);
		System.out.println(selectedbranch+ selectedsemester+selectedsubject+selectedgroup);
		return true;
		}
		return false;
	}
	
//	public static ResultSet existingbranch() throws ClassNotFoundException, SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<Branch> branchlist = new ArrayList<>();
//		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("select branchname,branchdesc from branch_mst where status=\"Y\"");
//		rs = pstmt.executeQuery();
////		while(rs.next()) {
////			Branch branch = new Branch();
//////			roledto.setRoleid(rs.getInt("roleid"));
////			branch.setBranchname(rs.getString("branchname"));
////			branch.setBranchdesc(rs.getString("branchdesc"));
////			branchlist.add(branch);
//////			System.out.println(rolelist);
////		}
////		rs.close();
////		pstmt.close();
////		con.close();
//		return rs;		
//	}
}