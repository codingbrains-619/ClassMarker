package com.classmarker.teacher.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.classmarker.dao.CommonDAO;
import com.classmarker.dao.TeacherDAO;

public class Question {
	
	public Question() {	}
	public Question(String question, String choice1, String choice2,
			String choice3, String choice4, String selectedchoice, List<Question> questionbanklist,
			String selectedquestionbank) {
		super();
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.selectedchoice = selectedchoice;
		this.questionbanklist = questionbanklist;
		this.selectedquestionbank = selectedquestionbank;
	}
	@Override
	public String toString() {
		return "Question [ question=" + question + ", choice1="
				+ choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4=" + choice4
				+ ", selectedchoice=" + selectedchoice + ", questionbanklist=" + questionbanklist
				+ ", selectedquestionbank=" + selectedquestionbank + "]";
	}
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	String uniqueid = (String) session.getAttribute("uniqueid");
	
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String selectedchoice;
	List<Question> questionbanklist = new ArrayList<Question>();
	private String selectedquestionbank;
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public List<Question> getQuestionbanklist() {
		return questionbanklist;
	}
	public void setQuestionbanklist(List<Question> questionbanklist) {
		this.questionbanklist = questionbanklist;
	}
	public String getSelectedquestionbank() {
		return selectedquestionbank;
	}
	public void setSelectedquestionbank(String selectedquestionbank) {
		this.selectedquestionbank = selectedquestionbank;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public String getSelectedchoice() {
		return selectedchoice;
	}
	public void setSelectedchoice(String selectedchoice) {
		this.selectedchoice = selectedchoice;
	}
	
	public String addquestion() throws ClassNotFoundException, SQLException {
		if(TeacherDAO.addquestion(question,choice1,choice2,choice3,choice4,
				selectedchoice)) {
			return "success";
		}
		
		return "fail";
	}
	
	public String questionbank() throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		questionbanklist = new ArrayList<Question>();
		
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select question_mst.questionname,question_mst.choice1,question_mst.choice2,question_mst.choice3,question_mst.choice4,question_mst.correctchoice,subject_mst.subjectname from question_mst,subject_mst,question_subject_mapping,userteacher_branch_semester_subject_mapping where question_mst.questionid=question_subject_mapping.questionid and subject_mst.sid=question_subject_mapping.subjectid and subject_mst.sid=userteacher_branch_semester_subject_mapping.subjectid and  userteacher_branch_semester_subject_mapping.userid=?");
		pstmt.setString(1, uniqueid);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Question ques = new Question();
			ques.setQuestion(rs.getString(1));
			ques.setChoice1(rs.getString(2));
			ques.setChoice2(rs.getString(3));
			ques.setChoice3(rs.getString(4));
			ques.setChoice4(rs.getString(5));
			ques.setSelectedchoice(rs.getString(6));
		
			questionbanklist.add(ques);
		}
		System.out.println(uniqueid);
		System.out.println(questionbanklist);
		return "success";
	}
	
	private void add(String string) {
		// TODO Auto-generated method stub
		
	}
	public String execute() {
		return "success";
	}
}