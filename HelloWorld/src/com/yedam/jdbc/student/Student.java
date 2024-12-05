package com.yedam.jdbc.student;

/*
 * tbl_student 의 칼럼을 필드로 선언.
 */

public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private int engScore;
	private int mathScore;
	private String creationDate;
	
	public Student() {
		
	}
	
	
	public Student(String stdNo, String stdName, String stdPhone) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPhone = stdPhone;
	}
	
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	// 목록으로 출력.
	public String showInfo() {
		return " " + stdNo + "  " + stdName + "  " + stdPhone;
	}
	public String selectInfo() {
		return " " + stdNo + "  " + stdName + "  " + stdPhone + " " + engScore + " " + mathScore;
	}
	
}
