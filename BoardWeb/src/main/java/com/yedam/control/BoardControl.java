package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("board_no");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건조회
		
		// 요청객체에 boardList정보를 담아서 jsp 전달.
		req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.

		req.getRequestDispatcher("html/board.jsp").forward(req, resp);
	}

}
