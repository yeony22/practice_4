package com.service;

import java.sql.Connection;

import com.common.JDBCTemplate;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardService {
	private BoardDAO bDAO = new BoardDAO();
	
	public int updateBoard(BoardDTO bDTO) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = bDAO.updateBoard(con, bDTO);
		
		try {
			if(result > 0)
				con.commit();
			else
				con.rollback();
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;		
	}
	
	public int deleteBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = bDAO.DeleteBoard(con, boardNo);
		
		try {
			if(result > 0)
				con.commit();
			else
				con.rollback();
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;		
	}

}
