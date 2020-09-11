package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CategoryDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardInsertForm
 */
// �Խù� ���¸� ���
@WebServlet("/boardInsertForm.do")
public class BoardInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CategoryDTO> list = null;
		
		BoardService bs = new BoardService();
		list = bs.selectCategoryList();	//	list�� ������ ī�װ� ����Ʈ�� ���� �޾ƿ� �����͸� ����
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/board/insertBoard.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
