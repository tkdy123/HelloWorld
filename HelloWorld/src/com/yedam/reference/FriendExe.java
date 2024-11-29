package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동";
		int age = 20;

		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1999-04-05";

		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "1999-08-08";

		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "1999-09-09";

		Friend[] myFriends = { f1, f2, f3 };


//		System.out.println(myFriends[0].friendName); // 홍길동
//		System.out.println(myFriends[0].friendPhone); // 010-1111-1111
//		System.out.println(myFriends[0].friendBirth); // 1999-09-09

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		System.out.println("이름을 입력하세요");
		while (run) {
			// 1. 사용자의 입력값을 searchName 에 저장.
			// 2. searchName의 값을 names배열에서 검색.
			// 3. 찾는 이름이 있으면 이름, 연락처, 생년월일 출력.
			// 4. 없으면 "찾는 이름 없음" 출력.
			// 5. 입력값이 quit 이면 while 반복문 종료.
			searchName = scn.nextLine();
			
			if (searchName.equals("quit")) {
				break;
			}
			
			boolean isOk = false;
			int idx = 0;
			for (int i = 0; i < myFriends.length; i++) {
				isOk = myFriends[i].friendName.equals(searchName);
				if (isOk) {
					idx = i;
					break;
				}
			}
			if (isOk) {
				System.out.println(myFriends[idx].friendName + ", " + myFriends[idx].friendPhone + ", " + myFriends[idx].friendBirth);
		
			} else {
				System.out.println("찾는 이름 없음");
			}

		} // end of while
		System.out.println("프로그램 종료");
	}
}
