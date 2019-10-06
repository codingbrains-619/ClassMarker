package com.classmarker.teacher.actions;

import java.sql.SQLException;

import com.classmarker.dao.TeacherDAO;

public class Question {
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String selectedchoice;
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
}
