package com.classmarker.student.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.classmarker.dao.CommonDAO;
import com.classmarker.dto.QuestionDTO;

public class TakeQuestion {

	private List<QuestionDTO> questions;
	
	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

	public String fetch() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();
		System.out.println("inside take ques");
//		HttpSession session=ServletActionContext.getRequest().getSession(false);
//		String testid = (String) session.getAttribute("testid");
//		System.out.println("Test id in question mapping " + testid);
		
		pstmt = con.prepareStatement("select questionname,choice1,choice2,choice3,choice4 from test_mst,question_mst,test_question_mapping where test_question_mapping.questionid=question_mst.questionid and test_question_mapping.testid=test_mst.testid");
//		pstmt.setString(1, testid);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			questions =  new ArrayList<QuestionDTO>();
		do {
			QuestionDTO question = new QuestionDTO(rs.getString("questionname"), rs.getString("choice1"), rs.getString("choice2"), rs.getString("choice3"), rs.getString("choice4")); 
			questions.add(question);
		}while(rs.next());
		System.out.println(questions);
			return "success";
		}
		return "fail";

	}
}
