package com.yedam.variable;

import java.util.Scanner;

public class TodoExe2 {
	public static void main(String[] args) {
		// Scanner scn = new Scanner();  => ctrl +shift + O
		String name = "김길동";
		
		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력.");
		String inputValue = scn.nextLine(); // 사용자의 입력값을 반환.
		
		if(name.equals(inputValue)) {
			System.out.println("같은 이름");
		} else{
			System.out.println("다른 이름");
		}
		System.out.println(inputValue.equals(name)); // 같은 이름. 다른 이름.
		
		System.out.println("end of prog.");
	}
}
