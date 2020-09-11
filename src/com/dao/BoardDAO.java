package com.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

}
