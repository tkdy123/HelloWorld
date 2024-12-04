package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";
		// 19960503 1234567
		str = "19960503 1234567";
		char c1 = str.charAt(9);
		switch(c1) {
		case '1': System.out.println("남자입니다."); break;
		case '2': System.out.println("여자입니다."); break;
		default: System.out.println("알 수 없음."); break;
		}
		
		System.out.println(c1 + ", " + (int)c1);
	}
}
