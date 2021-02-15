package com.cit.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	Connection conn = null;
	String query = null;
	Statement stmt =null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	private static BoardDao instance;
    private BoardDao(){}
    public static BoardDao getInstance(){
        if(instance==null)
            instance=new BoardDao();
        return instance;
    }
    
    private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool01");
		return ds.getConnection();
	}
    
    // boardList 보기
    public ArrayList<BoardDto> getList() {
    
    	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
    	try {
			conn = getConnection();
			query = "SELECT * FROM \"F_BOARD\"";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				list.add(new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println("연결오류");
			}
		}
    	return list;  	
    }

    // boardDetail 보기
    public ArrayList<BoardDto> getBoardDetail(int num){
    	
    	ArrayList<BoardDto> boardDetail = new ArrayList<BoardDto>();
    	
    	try {
			conn = getConnection();
			query = "SELECT * FROM \"F_BOARD\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				boardDetail.add(new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
    	} catch (Exception e) {
			System.out.println("상세보기 조회 오류");
		}finally {
			try {
				 if(rset != null) rset.close();
				 if(pstmt != null) pstmt.close();
				 if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
    	
		return boardDetail;
    	
    }
}
