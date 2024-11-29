package com.yedam.reference;

import java.util.Scanner;

/*
 *  친구정보 저장 기능. 
 *  1. 추가 2. 목록 3. 조회(숙제) 4. 수정(연락처) 5. 삭제 9. 종료
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10]; // 친구정보 저장 할 수 있는 공간 10개 확보
//		storage[0] = new Friend();   // 이렇게 꼭 사용!! 중요..
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "1999-01-01";
		String searchName = "";
		boolean isOk = false;
		
		while(run) {
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
						System.out.printf("%4s %14s \n", storage[i].friendName, storage[i].friendPhone );
					}
				}
				break;
			case 3: // 조회.
				System.out.println("친구 이름 입력 >> ");
				searchName = scn.nextLine();
				int idx = 0;
				for (int i = 0; i < storage.length; i++) {
					isOk = storage[i].friendName.equals(searchName);
					if(isOk) {
						idx = i;
						break;
					}
				} // end of for
				if (isOk) {
					System.out.printf("%4s %13s %13s" , storage[idx].friendName, storage[idx].friendPhone,  storage[idx].friendBirth);
					System.out.println();
				} else {
					System.out.println("찾는 값이 없습니다.");
				}
				break;
			case 4: // 수정(연락처).
				System.out.println("친구 이름 입력 >> ");
				searchName = scn.nextLine();
				System.out.println("바꿀 번호 입력 >> ");
				String phone2 = scn.nextLine();
				int id = 0;
				for (int i = 0; i < storage.length; i++) {
					isOk = storage[i].friendName.equals(searchName);
					if(isOk) {
						id = i;
						break;
					}
				} // end of for
				if (isOk) {
					storage[id] = new Friend();
					storage[id].friendName = searchName;
					storage[id].friendPhone = phone2;
				} else {
					System.out.println("찾는 값이 없습니다.");
				}
				break;
			case 5: // 삭제.
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
