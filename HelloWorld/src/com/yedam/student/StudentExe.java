package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(1); // 실체생성(인스턴스 생성)
		s1.studentName = "홍길동";
		s1.studentEng = 60;
		s1.studentMath = 70;
		System.out.println(s1.studentNum + ", " + s1.studentName + "의 합계 점수는 " +s1.sumScore() + "  평균 점수는 " + s1.avgScore());
		
		Student s2 = new Student(2, "김길동"); // 실체생성(인스턴스 생성)
		s2.studentEng = 70;
		s2.studentMath = 75;
		System.out.println(s2.studentNum + ", " + s2.studentName + "의 합계 점수는 " +s2.sumScore() + "  평균 점수는 " + s2.avgScore());

		Student s3 = new Student(3, "최길동" , 80, 90); // 실체생성(인스턴스 생성)
		System.out.println(s3.studentNum + ", " + s3.studentName + ", eng : " + s3.studentEng + ",  math : " + s3.studentMath);
		
		
		System.out.println(s1 == s2);
		
		int num = 100;
		
		
		
		
	}
}
