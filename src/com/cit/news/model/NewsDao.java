package com.cit.news.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NewsDao {
	Connection conn = null;
	String query = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	private static NewsDao instance;
    private NewsDao(){}
    public static NewsDao getInstance(){
        if(instance==null)
            instance=new NewsDao();
        return instance;
    }
    
    private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool01");
		return ds.getConnection();
	}
    
    public ArrayList<NewsDto> getNewsList() {
    	ArrayList<NewsDto> newsList = new ArrayList();
    	try {
			conn = getConnection();
			
			query = "select \"BOARD_NUM\", \"B_TITLE\", \"B_ENROLLED_DATE\", \"B_VIEWS\", SUBSTR(\"B_CONTENTS\", 1, 60) as \"B_CONTENTS\", \"U_ID\", " + 
					"\"B_CTGORY\", \"REF_NUM\", \"AUTHOR\", \"NEWS_LINK\"  from \"F_BOARD\" JOIN \"NEWS\""
					+ " USING (\"BOARD_NUM\") WHERE \"B_CTGORY\" = '채용' OR \"B_CTGORY\" = '기업' OR \"B_CTGORY\" = '인터뷰'";
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				int bNum = rset.getInt("BOARD_NUM");
				String title = rset.getString("B_TITLE");
				String content = rset.getString("B_CONTENTS");
				String uId = rset.getString("U_ID");
				String category = rset.getString("B_CTGORY");
				String author = rset.getString("AUTHOR");
				String newsLink = rset.getString("NEWS_LINK");
				java.util.Date enrollDate = new java.util.Date(rset.getDate("B_ENROLLED_DATE").getTime());
				int refNum = rset.getInt("REF_NUM");
				int views = rset.getInt("B_VIEWS");
				NewsDto ndto = new NewsDto(bNum, title, content, uId, category, author, newsLink, enrollDate, views, refNum);
				ndto.setImagePathList(getFiles(bNum));
				
				newsList.add(ndto);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
    	return newsList;
    }
    
    public ArrayList<String> getFiles(int boardNum) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	
    	ArrayList<String> images = new ArrayList<String>();
    	try {
    		query = "SELECT * FROM \"B_FILE\" WHERE \"BOARD_NUM\"= ?";
			conn = getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				images.add(rset.getString("PATH"));
			}
			
			return images;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return images;
    }

	
}
