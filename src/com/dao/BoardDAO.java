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
		
		String filePath = BoardDAO.class.getResource("/config/board-query.properties").getPath();
	
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
			pstmt.setString(4, bDTO.getBoardContent());
			pstmt.setString(5, bDTO.getBoardPwd());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		return list;
	}
	
	
	public ArrayList<BoardDTO> selectBoardList(Connection con) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO bDTO = new BoardDTO();
				
				bDTO.setBoardNo(rs.getInt("BOARDNO"));
				bDTO.setCaNo(rs.getInt("CANO"));
				bDTO.setCaName(rs.getString("CANAME"));
				bDTO.setBoardTitle(rs.getString("BOARDTITLE"));
				bDTO.setBoardWriter(rs.getString("BOARDWRITER"));
				bDTO.setBoardContent(rs.getString("BOARDCONTENT"));
				bDTO.setBoardDate(rs.getDate("BOARDDATE"));
				bDTO.setReadCount(rs.getInt("READCOUNT"));
				bDTO.setBoardPwd(rs.getString("BOARDPWD"));
				
				list.add(bDTO);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public BoardDTO selectBoardOne(Connection con, int boardNo) {
		BoardDTO bDTO = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bDTO = new BoardDTO();
				
				bDTO.setBoardNo(rset.getInt("BOARDNO"));
				bDTO.setCaNo(rset.getInt("CANO"));
				bDTO.setCaName(rset.getString("CANAME"));
				bDTO.setBoardTitle(rset.getString("BOARDTITLE"));
				bDTO.setBoardWriter(rset.getString("BOARDWRITER"));
				bDTO.setBoardContent(rset.getString("BOARDCONTENT"));
				bDTO.setBoardDate(rset.getDate("BOARDDATE"));
				bDTO.setReadCount(rset.getInt("READCOUNT"));
				bDTO.setBoardPwd(rset.getString("BOARDPWD"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
		
			}
		}
		return bDTO;
	}
	
	public int updateReadCount(Connection con, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReadCount");
		
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
	
	public int deleteBoard(Connection con, int boardNo) {
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

