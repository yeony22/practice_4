package com.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.common.JDBCTemplate;
import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.CategoryDTO;

public class BoardService {
	private BoardDAO bDAO = new BoardDAO();

	public int insertBoard(BoardDTO bDTO) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = bDAO.insertBoard(con, bDTO);
		
		try {
			if (result > 0)
				con.commit(); // 변경 사항을 수정
			else
				con.rollback(); // 없음 되돌리기
		} catch (Exception e) {
			e.printStackTrace();
					}
		return result;
	}

	public ArrayList<CategoryDTO> selectCategoryList() {
		Connection con = JDBCTemplate.getConnection();


		ArrayList<CategoryDTO> list = bDAO.selectCategoryList(con);
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<BoardDTO> selectBoardList() {
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<BoardDTO> list = bDAO.selectBoardList(con);
		
		try {
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BoardDTO SelectBoardOne(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardDTO bDTO = null;
		bDTO = bDAO.selectBoardOne(con, boardNo);
		
		try {
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return bDTO;
	}
	
	public BoardDTO updateBoardView(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = bDAO.updateReadCount(con, boardNo);
		BoardDTO bDTO = null;
		
		try {
			if(result > 0) {
				con.commit();
				bDTO = bDAO.selectBoardOne(con, boardNo);
			}
			else 
				con.rollback();
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return bDTO;
	}
	
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
		
		int result = bDAO.deleteBoard(con, boardNo);
		
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
