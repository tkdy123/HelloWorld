package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		// ln <= 줄바꿈
		String[] names = {"박창석", "홍영민", "김익수", "이화영"};
		
		Scanner scn = new Scanner(System.in);
		System.out.println("친구이름을 입력하세요 >>>");
		String search = scn.nextLine();
		
		// "입력한 이름이 존재합니다.", "입력한 이름이 없습니다."
		// end of prog.	
		boolean isOk = false;
		for (int i = 0; i < names.length; i++) {			
			isOk = names[i].equals(search);
			if(isOk) {
				break;
			}
		}
		// 책 112p.
		if (isOk) {
			System.out.printf("입력한 이름 %10s이(가) 존재합니다. 나이는 %2d 입니다.\n", search, 10);
		} else {
			System.out.printf("입력한 이름 " + search +"이(가) 없습니다.");
		}
		System.out.println("end of prog.");
	}
}
