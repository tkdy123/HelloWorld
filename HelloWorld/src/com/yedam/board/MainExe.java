package com.yedam.board;

import java.util.Scanner;

public class MainExe {

	static Scanner scn = new Scanner(System.in); // 필드.
	static BoardExe bexe = new BoardExe(); // 필드.
    static MemberExe mexe = new MemberExe();
	public static void main(String[] args) {
		
		boolean run = true;
		
		// 로그인 기능. 

		 // 인스턴스 생성. static 사용시 필요없음.

		while (run) {
			System.out.println("1.회원등록 2.목록 3.게시판 9.종료");
			System.out.println("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 회원등록
				System.out.println("회원 아이디 >> ");
				String id = scn.nextLine();
				System.out.println("회원 비밀번호 >> ");
				String pw = scn.nextLine();
				System.out.println("회원 이름 >> ");
				String name = scn.nextLine();
				System.out.println("회원 연락처 >> ");
				String phone = scn.nextLine();

				boolean result = MemberExe.addMember(new Member(id, pw, name, phone));
				if (result) {
					System.out.println("정상 등록되었습니다.");
				} else {
					System.out.println("등록 처리되지 않았습니다.");
				}
				break;
			case 2: // 목록
				Member[] list = MemberExe.memberList();
				for (Member member : list) {
					if (member != null) {
						System.out.println(member.showInfo());
					}
				}
				break;
			case 3: // 게시판 관련.
				System.out.println("회원 아이디 >> ");
				id = scn.nextLine();
				System.out.println("회원 비밀번호 >> ");
				pw = scn.nextLine();
				if (MemberExe.login(id, pw)) { // id & pw 체크.
					boardMethod(id); // 로그인 한 사용자 아이디를 활용.
				} else {
					System.out.println("id와 pw를 확인하세요");
				}
				break;
			case 9: // 종료
				run = false;
			} // end of switch.
		} // end of while.
		System.out.println("프로그램 끝");
	} // end of main.

	// 게시판 관련.

	public static void boardMethod(String id) {
		// 1.추가 2.목록 3.수정 4.삭제 9.상위메뉴로 이동
		boolean run = true;

		while (run) {
			System.out.println("1.글 등록 2.목록 3.수정 4.삭제 5.상세조회(글번호) 9.상위메뉴로 이동");
			System.out.println("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
//				System.out.println("글 번호 입력>> ");
				int bno = bexe.getNextNo();
				System.out.println("글 제목 입력>> ");
				String title = scn.nextLine();
				System.out.println("글 내용 입력>> ");
				String content = scn.nextLine();
//				System.out.println("작성자 입력>> ");
				String writer = id;
//				System.out.println("작성일시 입력>> ");
				java.util.Date ddd = new java.util.Date();

				Board board = new Board(bno, title, content, writer, ddd); // 밑이랑 같음
//				bexe.insertBoard(new Board(bno, title, content, writer, ddd));
				if (bexe.insertBoard(board)) {
					System.out.println("게시글 등록 완료.");
				} else {
					System.out.println("게시글 등록 실패.");
				}
				break;
			case 2: // 목록.
				Board[] list = bexe.boardList();
				for (Board brd : list) {
					if (brd != null) {
						System.out.println(brd.showInfo());
					}
				}
				break;
			case 3: // 수정(제목, 내용) = bno, title, content : Board 타입.
				System.out.println("수정할 글 번호를 입력하세요");
				bno = Integer.parseInt(scn.nextLine());
				System.out.println("글 제목 입력>> ");
				title = scn.nextLine();
				System.out.println("글 내용 입력>> ");
				content = scn.nextLine();

				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("권한을 확인하세요.");
					break;
				}
				// 사용자의 입력값을 updateBoard의 매개값으로 전달.
				board = new Board(bno, title, content, null, null);
				if (bexe.updateBoard(board)) {
					System.out.println("정상적으로 수정되었습니다.");
				} else {
					System.out.println("수정할 글 번호를 확인하세요");
				}
				break;

			case 4: // 삭제.
				System.out.println("삭제 할 글 번호를 입력하세요");
				bno = Integer.parseInt(scn.nextLine());
				// 글에 대한 권한 체크.
				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("권한을 확인하세요.");
					break;
				}
				if (bexe.deleteBoard(bno)) {
					System.out.println("정삭적으로 삭제 되었습니다.");
				} else {
					System.out.println("삭제 할 글 번호를 확인하세요.");
				}
				break;
			case 9: // 상위메뉴(회원관련 메뉴).
				return;
			}
		} // end of while.
	}
} // end of class.
