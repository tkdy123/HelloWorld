package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		// 검색조건.
		Search search = new Search();
//		search.setName("상");
//		search.setPhone("12");
		search.setEngScore(60); // 60점 이상.
		search.setOrderBy("std_name"); // 학생번호 정렬.
		
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search);
		for(Student std : list) {
			System.out.println(std.showInfo());
		}
		
	}
}