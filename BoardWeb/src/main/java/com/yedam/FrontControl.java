package com.yedam;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontControl extends HttpServlet {
	Map<String, Control> map;
	
	public FrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		// http://localhost:80/BoardWeb/hello.do
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path); // "/hello.do" 공통부분을 제외한 나머지 부분.
		
		// 요청 url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec();
	}
}
