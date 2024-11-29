package com.yedam.reference;

import java.util.Scanner;

/*
 *  배열 활용 연습.
 *  작성자 : 김상연
 *  작성일 : 2024.11.29
 *  
 *  수정일          수정자        수정내용
 *  -----------------------------------
 *  2024.11.29     홍길동        신규작업
 *  
 */

public class ArrayEx3 {
	public static void main(String[] args) {
		// 배열의 인덱스 활용(같은 순번에 있는 값들은 동일한 사람의 값)
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "의 점수는 " + scores[i] + "입니다.");
		}
		// quit 입력하면 프로그램 종료.
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = ""; // 사용자 입력값

		while (run) {
			// names 배열에서 사용자가 입력한 이름 찾아서 이름과 점수 출력.
			// quit의 값을 입력하면 프로그램 종료.

			// 1. 사용자의 입력값을 searchName에 저장.
			searchName = scn.nextLine();
			// 5. 입력값이 quit이면 while 반복문 종료.
			if (searchName.equals("quit")) {
				break;
			}

			// 2. searchName의 값을 names 배열에서 검색.
			boolean isOk = false;
			int idx = 0;
			System.out.println("이름을 입력하세요>> ");

			for (int i = 0; i < names.length; i++) {
				isOk = names[i].equals(searchName);
				if (isOk) {
					idx = i;
					break;
				}
			}
			// 3. 찾는 이름이 있으면 이름과 점수 출력.
			if (isOk) {
				System.out.println(names[idx] + scores[idx]);
			}
			// 4. 없으면 "찾는 이름 없음" 출력.			
			else {
				System.out.println("찾는 이름 없음");
			} // end of if 구문.
				// 5. 입력값이 quit 이면 while 반복문 종료.
		} // end of while
		System.out.println("프로그램 종료");
	}
}