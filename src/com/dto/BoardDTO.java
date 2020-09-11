package com.dto;

import java.io.Serializable;
import java.sql.Date;


public class BoardDTO implements Serializable{
	
	private int boardNo;
	private int cano;
	private String caName;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int readCount;
	private String boardPwd;
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int boardNo, int cano, String caName, String boardTitle, String boardWriter, String boardContent,
				Date boardDate, int readCount, String boardPwd) {
		super();
		this.boardNo = boardNo;
		this.cano = cano;
		this.caName = caName;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.readCount = readCount;
		this.boardPwd = boardPwd;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", cano=" + cano + ", caName=" + caName + ", boardTitle=" + boardTitle
				+ ", boardWriter=" + boardWriter + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", readCount=" + readCount + ", boardPwd=" + boardPwd + "]";
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCano() {
		return cano;
	}
	public void setCano(int cano) {
		this.cano = cano;
	}
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getBoardPwd() {
		return boardPwd;
	}
	public void setBoardPwd(String boardPwd) {
		this.boardPwd = boardPwd;
	}
	
}
