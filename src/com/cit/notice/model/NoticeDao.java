package com.cit.notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.cit.board.model.BoardDto;

public class NoticeDao {
	Connection conn = null;
	Statement stmt =null;
	PreparedStatement pstmt = null;
	int result = 0;
	ResultSet rset = null;
	
	private static NoticeDao instance;
    private NoticeDao(){}
    public static NoticeDao getInstance(){
        if(instance==null)
            instance=new NoticeDao();
        return instance;
    }
    
    private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool01");
		return ds.getConnection();
	}
    
    //전체 글 목록 가져오기xxx`
    public List<BoardDto> noticeList(){
    	List<BoardDto> list = new ArrayList<BoardDto>();
    	try {
    		conn = getConnection();
    		String query = "SELECT * FROM \"F_BOARD\" WHERE \"B_CTGORY\" = '공지사항' ORDER BY \"B_ENROLLED_DATE\" DESC";
    		pstmt = conn.prepareStatement(query);
    		rset = pstmt.executeQuery();
    		while(rset.next()) {
    			list.add(new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return list;
    }  
    
    //글 삭제하기
    public int noticeDel(int num) {
    	try {
    		conn = getConnection();
    		String query =" DELETE FROM \"F_BOARD\" WHERE \"BOARD_NUM\" = ?";
    		pstmt = conn.prepareStatement(query);
    		pstmt.setInt(1, num);
    		result = pstmt.executeUpdate();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return result;
    }
}
