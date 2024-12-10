package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * HttpServlet 상속.
 * service() 재정의.
 * parameter(board_no) 값을 받아서 상세조회.
 * attribute(board)를 담아서 board.jsp에 전달하고
 * board.jsp에서는 전달받은 값을 출력.
 * 
 */
@WebServlet("/board.action")
public class BoardServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String bno = req.getParameter("board_no");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건조회
		
		// 요청객체에 boardList정보를 담아서 jsp 전달.
		req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.
		// 요청재지정.
		req.getRequestDispatcher("html/board.jsp").forward(req, resp);
		
		}

	}
