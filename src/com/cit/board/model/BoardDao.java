package com.cit.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public List<BoardDto> getList() {
    
    	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
    	try {
			conn = getConnection();
			query = "SELECT \"B_TITLE\", \"B_ENROLLED_DATE\", \"B_VIEWS\", \"U_ID\" FROM \"F_BOARD\" WHERE \"B_CTGORY\" = '인터뷰'";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				list.add(new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),
							rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println("연결오류");
			}
		}
    	return list;  	
    }
    
}
