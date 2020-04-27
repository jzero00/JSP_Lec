package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.BoardModifyRequest;
import com.jsp.service.BoardService;

public class BoardModifyAction implements Action {

	private BoardService boardService;	//=BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String url = "/board/modify_success";
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardModifyRequest boardReq = new BoardModifyRequest(title, writer, content, bno);
		BoardVO board = boardReq.toBoardVO();

		try {
			boardService.modify(board);
			
			request.setAttribute("board", board);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		
		return url;
	}

}
