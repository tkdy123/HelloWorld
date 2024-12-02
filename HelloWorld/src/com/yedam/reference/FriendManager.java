package com.yedam.reference;

import java.util.Scanner;

/*
 *  친구정보 저장 기능. 
 *  1. 추가 2. 목록 3. 조회(숙제) 4. 수정(연락처) 5. 삭제 9. 종료
 *  
 *		storage[0] = new Friend();   // 이렇게 꼭 사용!! 중요..
 *		storage[0].friendName = "홍길동";
 *		storage[0].friendPhone = "010-1111-1111";
 *		storage[0].friendBirth = "1999-01-01";
 *
 *	C(reate) R(ead) U(pdate) D(elete)
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10]; // 친구정보 저장 할 수 있는 공간 10개 확보

		String searchName = "";
		boolean isOk = false;

		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println(" 1.추가 2.목록 3.조회(숙제) 4.수정(연락처) 5.삭제 9.종료 ");
			System.out.println("--------------------------------------------------");
			System.out.print("선택 >> ");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
				System.out.println("친구 이름 입력 >> ");
				String name = scn.nextLine();
				System.out.println("친구 연락처 입력 >> ");
				String phone = scn.nextLine();
				System.out.println("친구 생일 입력 >> ");
				String birth = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
//					System.out.println(storage[i]);
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						break;
					}
				}
				break; // switch 종료.
			case 2: // 목록.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s \n", storage[i].friendName, storage[i].friendPhone);
					}
				}
				break;
			case 3: // 조회.
				System.out.println("친구 이름 입력 >> ");
				name = scn.nextLine();
				int idx = 0;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 이 아닌 요소 기준 조회.
						isOk = storage[i].friendName.equals(name);
						if (isOk) {
							idx = i;
							break; // for 반복문에..
						}
					}
				} // end of for
				if (isOk) {
					System.out.printf("이름 : %4s | 연락처 : %13s | 생년월일 : %13s", storage[idx].friendName,
							storage[idx].friendPhone, storage[idx].friendBirth);
					System.out.println();
				} else {
					System.out.println("찾는 이름이 없습니다.");
				}
				break; // switch 종료.
			case 4: // 수정(연락처).
				System.out.println("연락처를 수정 할 친구 이름 입력하세요");
				name = scn.nextLine();
				System.out.println(" 수정 할 연락처를 입력하세요");
				phone = scn.nextLine();

				// 10개 중에서 6개 저장, 4개 null.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].friendName.equals(name)) {
							storage[i].friendPhone = phone;
							break;
						}
					}
				}
				break;
			case 5: // 삭제.
				System.out.println("정보를 삭제 할 친구 이름 입력하세요");
				name = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].friendName.equals(name)) {
							storage[i] = null;
							break;
						}
					}
				}
				break;
			case 9: // 종료.
				run = false;
				break; // switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch
		} // end of while.
		System.out.println("프로그램 끝");
	} // end of main().
} // end of class.
