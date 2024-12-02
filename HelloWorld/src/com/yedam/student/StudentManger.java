package com.yedam.student;

import java.util.Scanner;

import com.yedam.reference.Friend;

/*
 * CRUD 처리.
 * 1. 추가 2. 목록 3. 수정(학생번호로 영어, 수학 점수 수정) 4. 삭제 9. 종료 
 */
public class StudentManger {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Student[] storage = new Student[10]; // 생성자.
		int engSum = 0;
		int mathSum = 0;
		double engAvg = 0.0;
		double mathAvg = 0.0;
		
		boolean isOk = false;
		
		
		
		while(run) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println(" 1.추가 2.목록 3.수정(영어, 수학) 4.삭제 5.상세조회(합계, 평균) 6.합계점수기준 정렬 9.종료 ");
			System.out.println("------------------------------------------------------------------------------");
			System.out.print("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu){
			case 1: // 추가
				System.out.println("학생 번호 입력 >> ");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("학생 이름 입력 >> ");
				String name = scn.nextLine();
				System.out.println("학생 영어 점수 입력 >> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.println("학생 수학 점수 입력 >> ");
				int math = Integer.parseInt(scn.nextLine());
				
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Student(number, name, eng, math); // 인스턴스 생성.
//						storage[i].studentNum = number;
//						storage[i].studentName = name;
//						storage[i].studentEng = eng;
//						storage[i].studentMath = math;
						break;
					}
				}
				break; // switch 종료.
			case 2: // 목록
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
//						System.out.printf("학생번호 : %2d번 | 학생이름 : %2s | 영어점수 : %2d점 | 수학점수 : %2d점 \n", storage[i].studentNum, storage[i].studentName, storage[i].studentEng, storage[i].studentMath);
						storage[i].introduce();
					}
				}
				break;
			case 3: // 수정(영어, 수학)
				System.out.println("점수를 수정 할 학생번호를 입력하세요");
				number = Integer.parseInt(scn.nextLine());
				System.out.println("수정 할 영어 점수를 입력하세요");
				eng = Integer.parseInt(scn.nextLine());
				System.out.println("수정 할 수학 점수를 입력하세요");
				math = Integer.parseInt(scn.nextLine());

				// 10개 중에서 6개 저장, 4개 null.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].studentNum == number) {
							storage[i].studentEng = eng;
							storage[i].studentMath = math;
							break;
						}
					}
				}
				break;
			case 4: // 삭제
				System.out.println("정보를 삭제 할 학생번호를 입력하세요");
				number = Integer.parseInt(scn.nextLine());
				
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if(storage[i].studentNum == number) {
							storage[i] = null;
							break;
						}
					}
				} break;
			case 5: // 상세조회(합계, 평균)
				for ( int i = 0; i < storage.length; i++) {
					
					if (storage[i] != null) {
						engSum += storage[i].studentEng;
						mathSum += storage[i].studentMath;
						engAvg = engSum / 2;
						mathAvg = mathSum / 2;
					}
										
				}
				System.out.printf("영어 점수의 합은 %3d \n", engSum);
				System.out.printf("수학 점수의 합은 %3d \n", mathSum);
				System.out.printf("영어 점수의 평균은 %3f \n", engAvg);
				System.out.printf("수학 점수의 평균은 %3f \n", mathAvg);
				engSum = 0;
				mathSum = 0;
				engAvg = 0.0;
				mathAvg = 0.0;
				break;
			case 6: // 합계점수기준 정렬
				
			case 9: // 종료
				run = false;
				break; // switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch.

		} // end of while.
		System.out.println("프로그램을 종료합니다.");
	} // end of main.
} // end of class.
