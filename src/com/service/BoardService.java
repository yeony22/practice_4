package com.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.CategoryDTO;

import static com.common.JDBCTemplate.*;

public class BoardService {

	private BoardDAO bDAO = new BoardDAO();
	
	public int insertBoard(BoardDTO bDTO) {
		Connection con = getConnection();
		
		int result = bDAO.insertBoard(con, bDTO);
		
		try {
			if (result > 0)
				con.commit(); // 변경 사항을 수정
			else
				con.rollback(); // 없음 되돌리기
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public ArrayList<CategoryDTO> selectCategoryList() {
		Connection con = getConnection();

		ArrayList<CategoryDTO> list = bDAO.selectCategoryList(con);
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return list;
	}

}
