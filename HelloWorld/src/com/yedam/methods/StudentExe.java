package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001");
		
//		s1.setStdNo("S001");
		s1.setStdName("홍길동");
		s1.setEngScore(70);
		s1.setMathScore(75);
		
		Student s2 = new Student("S002", "김길동", 80, 90);
		
				
				
		System.out.println(s1.showInfo());
		System.out.println(s2.showInfo());
	}
}
