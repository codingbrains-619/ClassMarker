package com.classmarker.student.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classmarker.dao.CommonDAO;
import com.classmarker.dto.LandingDTO;
import com.classmarker.dto.QuestionDTO;

public class TakeQuestion {

	private List<QuestionDTO> questions;
	
	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

	public String showquestion() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = CommonDAO.getConnection();

		String testid = (String) session.getAttribute("testid");
		System.out.println("Test id in question mapping " + testid);
		
		pstmt = con.prepareStatement("select questionname,choice1,choice2,choice3,choice4 from question_mst");
		pstmt.setString(1, testid);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			questions =  new ArrayList<QuestionDTO>();
		}
		do {
			QuestionDTO question = new QuestionDTO(rs.getString("questionname"), rs.getString("choice1"), rs.getString("choice2"), rs.getString("choice3"), rs.getString("choice4")) 
			questions.add(question);
		}while(rs.next());
			return "succeess";
		}
		return "fail";

	}
}
