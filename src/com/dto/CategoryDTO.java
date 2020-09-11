package com.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable{
	
	private int cano;
	private String caName;
	public CategoryDTO() {
		super();
	}
	public CategoryDTO(int cano, String caName) {
		super();
		this.cano = cano;
		this.caName = caName;
	}
	@Override
	public String toString() {
		return "Category [cano=" + cano + ", caName=" + caName + "]";
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
	
}
