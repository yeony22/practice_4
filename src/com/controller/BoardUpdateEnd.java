package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardUpdateEnd
 */
@WebServlet("/boardUpdateEnd.do")
public class BoardUpdateEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateEnd() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int caNo = Integer.parseInt(request.getParameter("caNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriter");
		String boardPwd = request.getParameter("boardPwd");
		String boardContent = request.getParameter("boardContent");
		
		BoardService bService = new BoardService();
		BoardDTO bDTO = new BoardDTO();
		
		bDTO.setBoardNo(boardNo);
		bDTO.setCaNo(caNo);
		bDTO.setBoardTitle(boardTitle);
		bDTO.setBoardWriter(boardWriter);
		bDTO.setBoardPwd(boardPwd);
		bDTO.setBoardContent(boardContent);
		
		int result = bService.updateBoard(bDTO);
		
		if(result > 0) {
			System.out.println("데이터 변경 성공");
			response.sendRedirect("boardList.do");
		}
		else
			System.out.println("데이터 변경 실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
