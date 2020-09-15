package com.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable{
	private int caNo;
	private String caName;
	
	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(int caNo, String caName) {
		super();
		caNo = this.caNo;
		caName = this.caName;
	}

	public int getCano() {
		return caNo;
	}

	public void setCano(int caNo) {
		this.caNo = caNo;
	}

	public String getCaName() {
		return caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}
}
