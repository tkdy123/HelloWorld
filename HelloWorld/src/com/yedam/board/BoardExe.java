package com.yedam.board;

import java.util.Date;

/*
 * 1. 등록 2. 목록
 */
public class BoardExe {
	private Board[] storage; // 필드.

	public BoardExe() {
		storage = new Board[10];
		storage[1] = new Board(2, "자바는 재밌어", "열심히 합시다", "user01", new Date());
		storage[2] = new Board(3, "오늘은 화요일", "3일이나 남았네", "user02", new Date());
		storage[9] = new Board(1, "자바", "열심히", "user03", new Date());
	}

//	public BoardExe() { // 초기화.
//		storage = new Board[10];
//	}

	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}

	// 목록.
	public Board[] boardList() {
		// 정렬.
		for (int j = 0; j < storage.length - 1; j++) {
			for (int i = 0; i < storage.length - 1; i++) {
				// 뒷자리가 null 이면 nothing.
				if (storage[i+1] == null) {
					continue;
				}
				Board temp = null;
				if (storage[i] == null //
						||storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
					// 위치변경 [i] <--> [i + 1]
					temp = storage[i];
					storage[i] = storage[i + 1];
					storage[i + 1] = temp;
				}
			} // end of for(i)
		} // end of for(j)
		return storage;
	}

	// 글번호 가져오는 메소드.
	// null 이 아닌 카운트에 + 1 한 값을 반환. (X)
	// boardNo의 max 값에 + 1 한 값을 반환. (o)
	public int getNextNo() {
		int cnt = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (cnt < storage[i].getBoardNo()) {
					cnt = storage[i].getBoardNo();
				}
			}
		}
		return cnt + 1;
	}

	// 글 삭제 기능 => 매개값은 글번호, 반환값은 true/ false, deleteBoard().

	public boolean deleteBoard(int boardNo) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == boardNo) {
				storage[i] = null;
				return true;
			}
		}
		return false;
	}

	// 삭제, 수정 권한 있는지 체크 => 매개값은 글 번호, 작성자, 반환값은 true/false.
	// checkResponsibility()
	public boolean checkResponsibility(int boardNo, String writer) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == boardNo && storage[i].getWriter().equals(writer)) {
				return true;
			}
		}
		return false;
	}

	// 수정(제목, 내용) => 매개값은 글번호, 제목, 내용 | 반환값은 true/false, updateBoard().
	public boolean updateBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == board.getBoardNo()) {
				storage[i].setTitle(board.getTitle());
				storage[i].setContent(board.getContent());
				return true;
			}
		}
		return false;
	}
} // end of class.
