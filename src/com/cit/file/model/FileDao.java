package com.cit.file.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.cit.news.model.NewsDao;

public class FileDao {
	Connection conn = null;
	String query = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	private static FileDao instance;

	private FileDao() {
	}

	public static FileDao getInstance() {
		if (instance == null)
			instance = new FileDao();
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool01");
		return ds.getConnection();
	}
	
	public int insertFile(List<FileDto> fList, Connection conn) {
		try {
			
			for(int i=0; i<fList.size(); i++) {
				System.out.println(i);
				query = "INSERT INTO \"B_FILE\" VALUES(?, ?, BOARD_SEQ.currval)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fList.get(i).getcName());
				pstmt.setString(2, fList.get(i).getPath());
				pstmt.executeUpdate();
			}
			
			return 1;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				
			} catch (Exception e2) {
			}
		}
		
		return 0;
		
	}
	
	public int updateFile(List<FileDto> fList, int boardNum, Connection conn) {
		try {
			
			for(int i=0; i<fList.size(); i++) {
				query = "UPDATE \"B_FILE\" SET \"C_NAME\" = ? , \"PATH\" = ? WHERE \"BOARD_NUM\" = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fList.get(i).getcName());
				pstmt.setString(2, fList.get(i).getPath());
				pstmt.setInt(3, boardNum);
				pstmt.executeUpdate();
			}
			
			return 1;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				
			} catch (Exception e2) {
			}
		}
		
		return 0;
		
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

			while (rset.next()) {
				images.add(rset.getString("PATH"));
			}

			return images;

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
		return images;
	}
	
	
	public int delFile(int boardNum) {
		int rs =0;
		try {
			conn = getConnection();
			query = "DELETE \"B_FILE\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
			
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	public int delPost(int boardNum) {
		int rs =0;
		try {
			conn = getConnection();
			query = "DELETE \"F_BOARD\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeUpdate();
			
			return rs;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rs;
		
	}
}
