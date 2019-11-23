package com.classmarker.dto;

public class ResultDTO {
//	private String teachername;
	private String marksperquestion;
	private String subjectname;
	private String testname;
	private String subjectcode;
	private String result;
//	private String branchname;
//	private String semestername;
//	private String groupname;
	public String getMarksperquestion() {
		return marksperquestion;
	}
	public void setMarksperquestion(String marksperquestion) {
		this.marksperquestion = marksperquestion;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultDTO [marksperquestion=" + marksperquestion + ", subjectname=" + subjectname + ", testname="
				+ testname + ", subjectcode=" + subjectcode + ", result=" + result + "]";
	}
	public ResultDTO(String marksperquestion, String subjectname, String testname, String subjectcode, String result) {
		super();
		this.marksperquestion = marksperquestion;
		this.subjectname = subjectname;
		this.testname = testname;
		this.subjectcode = subjectcode;
		this.result = result;
	}
	
	public ResultDTO() {}
}
