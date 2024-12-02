package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal1 = new Calculator(); // 인스턴스 생성.
		int sum = cal1.sum(10, 20);
		
		System.out.println("합계 : " + cal1.sum(10, 20));
		System.out.println("합계 : " + cal1.sum(10.3, 20));
		System.out.println("큰값은  : " + cal1.max(10, 20.2));
		
		cal1.printStar(3);
		
		int[] intAry = { 3, 6, 9, 12};
		sum = cal1.sumAry(intAry);
		System.out.println("intAry의 합계 " + sum);
		
		double result = cal1.averageAry(intAry);
		System.out.println("intAry의 평균 " + result);
		
		Student s1 = new Student(1, "홍길동", 83, 78);
		Student s2 = new Student(2, "김길동", 77, 83);
		Student s3 = new Student(3, "최길동", 88, 91);
		
		Student[] stdAry = { s1, s2, s3 };
		Student std = cal1.getMaxScore(stdAry);
		System.out.println("최고 영어 점수는 " + std.studentEng + ", 이름은 " + std.studentName);
	}
}
