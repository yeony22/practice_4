package com.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dto.BoardDTO;
import com.dto.CategoryDTO;

public class BoardDAO {
	private Properties prop;
	
	public BoardDAO() {
		prop = new Properties();
		
		String filePath = BoardDAO.class.getResource("../config/board-query.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		}
	}

	public int insertBoard(Connection con, BoardDTO bDTO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bDTO.getCaNo());
			pstmt.setString(2, bDTO.getBoardTitle());
			pstmt.setString(3, bDTO.getBoardWriter());
			pstmt.setString(4, bDTO.getBoardPwd());
			pstmt.setString(5, bDTO.getBoardContent());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return result;
	}

	public ArrayList<CategoryDTO> selectCategoryList(Connection con) {
		ArrayList<CategoryDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryDTO cDTO = new CategoryDTO();
				
				cDTO.setCano(rs.getInt("CANO"));
				cDTO.setCaName(rs.getString("CANAME"));
				
				list.add(cDTO);
			}
		}catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
					
		}
		return list;
	}
	
	
	public int updateBoard(Connection con, BoardDTO bDTO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bDTO.getCaNo());
			pstmt.setString(2,  bDTO.getBoardTitle());
			pstmt.setString(3, bDTO.getBoardWriter());
			pstmt.setString(4, bDTO.getBoardPwd());
			pstmt.setString(5,  bDTO.getBoardContent());
			pstmt.setInt(6,  bDTO.getBoardNo());
			
			result = pstmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return result;
	}
	
	public int DeleteBoard(Connection con, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}		
}

