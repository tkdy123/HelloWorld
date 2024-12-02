package com.yedam.student;
/*
 * 학생의 성적관리 Prog.
 * 학생번호, 학생이름, 영어점수, 수학점수 
 * 
 */
public class Student {
	public int studentNum; // 필드.
	public String studentName; // 
	public int studentEng; // 
	public int studentMath; // 	
	
	// 컴파일러가 기본 생성자를 만들어준다.
//	public Student() { }
	
	public Student(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public Student(int studentNum, String studentName) {
		this.studentNum = studentNum;
		this.studentName = studentName;
	}
	public Student(int studentNum, String studentName, int studentEng, int studentMath) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentEng = studentEng;
		this.studentMath = studentMath;
	}
	
	// 메소드.
	public void smile() {
			System.out.println("학생이 웃습니다.");
	}
	public void introduce() {
		System.out.println("이름은 " + studentName + "이고 학번은 " + studentNum); 
	}
	
	public int sumScore() {
		return studentEng + studentMath;
	}
	
	public double avgScore() {
		return (double) (studentEng + studentMath) / 2;
	}
}
