package com.yedam.reference;

import java.util.Scanner;
/*
 *  은행 프로그램 v 1.0
 *  작성자 : 김상연
 *  작성일 : 2024.11.29
 */
public class ArrayEx2 {
	public static void main(String[] args) {
		// 변수 초기화. 10만원 초과불가, -잔고 불가   
		// : 90000원에서 20000원 입금안됨. 
		boolean run = true;
		int balance = 0;
		int maxBalance = 100000; // 최대금액
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------");
			System.out.println("선택> ");
			int menu = Integer.parseInt(scn.nextLine()); // 1 ,2 
			
			switch(menu) {
			case 1:
				System.out.print("예금액> ");
				int inBalance = Integer.parseInt(scn.nextLine());
				if(balance + inBalance <= maxBalance) {
					balance += inBalance;					
					System.out.println("정상처리 됐습니다.");
				break;
				} else {
					System.out.println("금액초과입니다.");
					break;
				}
			case 2:
				System.out.print("출금액> ");
				inBalance = Integer.parseInt(scn.nextLine());
				if (balance - inBalance > 0) {
					balance -= inBalance;					
					break;
				} else {
					System.out.println("마이너스 잔고로 출금 할 수 없음.");
					break;
				}
			case 3:
				System.out.print("잔고> " + balance);
				break;
			case 4:			
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
