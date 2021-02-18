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

import com.cit.file.model.FileDao;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDto;

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
			query = "SELECT * FROM \"F_BOARD\" WHERE \"B_CTGORY\" = '사는얘기' OR \"B_CTGORY\" ='고민' OR \"B_CTGORY\"= '면접후기' OR \"B_CTGORY\" ='국비교육' OR \"B_CTGORY\" = '스터디모집' ORDER BY \"B_ENROLLED_DATE\" DESC";
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
    public BoardDto getBoardDetail(int num){
    	
    	BoardDto boardDetail = null;
    	
    	try {
			conn = getConnection();
			query = "SELECT * FROM \"F_BOARD\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				boardDetail = new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8));
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
    
    // board 삭제
    public int delPost(int num) {
    	int result =0;
    	try {
    		conn = getConnection();
    		conn.setAutoCommit(false);
    		FileDao.getInstance().delFile(num);
    		String query = "DELETE FROM \"F_BOARD\" WHERE BOARD_NUM = ?";
    		pstmt = conn.prepareStatement(query);
    		pstmt.setInt(1, num);
    		result = pstmt.executeUpdate();
    		conn.commit();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return result;
    }
       
    public int insertPost(BoardDto bdto, List<FileDto> fList) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			query = "insert into \"F_BOARD\" values(BOARD_SEQ.nextval, ?, sysdate, 0, ?, ?, ?, BOARD_SEQ.currval)";
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, bdto.getTitle());
			pstmt.setString(2, bdto.getCont());
			pstmt.setString(3, bdto.getId());
			pstmt.setString(4, bdto.getCate());
			
			pstmt.executeUpdate();
			
			int fileRs = FileDao.getInstance().insertFile(fList, conn);
			if(fileRs>0) {
				conn.commit();
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}
    
    public BoardDto getPost(int boardNum) {
		BoardDto bdto = null;
		
		try {
			conn = getConnection();

			query = "select \"BOARD_NUM\", \"B_TITLE\", \"B_ENROLLED_DATE\", \"B_VIEWS\",\"B_CONTENTS\", \"U_ID\", "
					+ "\"B_CTGORY\", \"REF_NUM\" from \"F_BOARD\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNum);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int bNum = rset.getInt("BOARD_NUM");
				String title = rset.getString("B_TITLE");
				String content = rset.getString("B_CONTENTS");
				String uId = rset.getString("U_ID");
				String category = rset.getString("B_CTGORY");
				java.sql.Date enrollDate = rset.getDate("B_ENROLLED_DATE");
				int refNum = rset.getInt("REF_NUM");
				int views = rset.getInt("B_VIEWS");
				bdto = new BoardDto(bNum, title, enrollDate, views, content, uId, category, refNum);
				bdto.setImagePathList(FileDao.getInstance().getFiles(bNum));
			}
			return bdto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return bdto;
	}
    public int updatePost(BoardDto bdto, List<FileDto> fList) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			query = "UPDATE \"F_BOARD\" SET \"B_TITLE\" = ? , \"B_CTGORY\" = ? ,\"B_CONTENTS\" = ? WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, bdto.getTitle());
			pstmt.setString(2, bdto.getCate());
			pstmt.setString(3, bdto.getCont());
			pstmt.setInt(4, bdto.getNum());
			
			pstmt.executeUpdate();
			System.out.println("성공1");
			
			int fileRs = FileDao.getInstance().updateFile(fList,bdto.getNum(), conn);
			System.out.println("성공2");
			if(fileRs>0) {
				conn.commit();
			}
			
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;	
	}

    public ArrayList<BoardDto> getMyList(String id) {

    	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
    	try {
			conn = getConnection();
			query = "SELECT * FROM \"F_BOARD\" WHERE \"U_ID\" = ?  ORDER BY \"B_ENROLLED_DATE\" DESC";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BoardDto(rset.getInt(1),rset.getString(2),rset.getDate(3),rset.getInt(4),
							rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println("연결오류");
			}
		}
    	return list;  	
    }

}
