package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/boardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cano = Integer.parseInt(request.getParameter("cano"));
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriter");
		String boardPwd = request.getParameter("boardPwd");
		String boardContent = request.getParameter("boardContent");
		
		BoardService bs = new BoardService();
		
		BoardDTO bDTO = new BoardDTO();
		
		bDTO.setCaNo(cano);
		bDTO.setBoardTitle(boardTitle);
		bDTO.setBoardWriter(boardWriter);
		bDTO.setBoardPwd(boardPwd);
		bDTO.setBoardContent(boardContent);
		
		int result = bs.insertBoard(bDTO);
		
		if (result >0) {
			System.out.println("데이터 추가 성공");
			response.sendRedirect("boardList.do");
		} else {
			System.out.println("추가 실패");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
