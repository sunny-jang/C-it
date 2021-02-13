package com.cit.news.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.cit.board.model.BoardDto;

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
    
    public ArrayList<BoardDto> newslist(int num, String title, Date date, int views, String cont, String id, String cate, int rNum,
			String author, String newsLink) {
    	//NewsDto ndto = null;
    	BoardDto bdto = null;
    	ArrayList<BoardDto>list = new ArrayList<BoardDto>();
    	try {
			conn = getConnection();
			query = "SELECT * FROM \"NEWS\" JOIN \"F_BOARD\" USING (\"BOARD_NUM\") WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdto.getNum());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				bdto = new BoardDto(
					rset.getInt("BOARD_NUM"),
					rset.getString("B_TITLE"),
					rset.getDate("B_ENROLLED_DATE"),
					rset.getInt("B_VIEWS"),
					rset.getString("B_CONTENTS"),
					rset.getString("U_ID"),
					rset.getString("B_CTGORY"),
					rset.getInt("REF_NUM"),
					rset.getString("AUTHOR"),
					rset.getString("NEWS_LINK")
				);
				list.add(bdto);
			}
	   }catch (Exception e) {
		   e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return list;
    }
}