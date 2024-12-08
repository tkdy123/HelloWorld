package com.yedam.jdbc.student;
/*
 *  이름, 연락처, 영어, 수학, 정렬 조건.
 */
public class Search {
	// 필드.
	private String name;
	private String phone;
	private int engScore;
	private int mathScore;
	private String orderBy = "eng_score";
	
	// getter, setter.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
} // end of class.
