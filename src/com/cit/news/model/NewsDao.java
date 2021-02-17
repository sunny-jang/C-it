package com.cit.news.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.cit.board.model.BoardDao;
import com.cit.file.model.FileDao;
import com.cit.file.model.FileDto;

public class NewsDao {
	Connection conn = null;
	String query = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	private static NewsDao instance;

	private NewsDao() {
	}

	public static NewsDao getInstance() {
		if (instance == null)
			instance = new NewsDao();
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

			query = "select \"BOARD_NUM\", \"B_TITLE\", \"B_ENROLLED_DATE\", \"B_VIEWS\",\"B_CONTENTS\", \"U_ID\", "
					+ "\"B_CTGORY\", \"REF_NUM\", \"AUTHOR\", \"NEWS_LINK\"  from \"F_BOARD\" JOIN \"NEWS\""
					+ " USING (\"BOARD_NUM\") WHERE \"B_CTGORY\" = '채용' OR \"B_CTGORY\" = '기업' OR \"B_CTGORY\" = '인터뷰'"
					+ "ORDER BY \"B_ENROLLED_DATE\" DESC";
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
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
				NewsDto ndto = new NewsDto(bNum, title, content, uId, category, author, newsLink, enrollDate, views,
						refNum);
				ndto.setImagePathList(FileDao.getInstance().getFiles(bNum));

				newsList.add(ndto);
			}
			return newsList;
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
		return newsList;
	}
	
	
	public NewsDto getNews(int boardNum) {
		NewsDto ndto = null;
		
		try {
			conn = getConnection();

			query = "select \"BOARD_NUM\", \"B_TITLE\", \"B_ENROLLED_DATE\", \"B_VIEWS\",\"B_CONTENTS\", \"U_ID\", "
					+ "\"B_CTGORY\", \"REF_NUM\", \"AUTHOR\", \"NEWS_LINK\"  from \"F_BOARD\" JOIN \"NEWS\""
					+ " USING (\"BOARD_NUM\") WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNum);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
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
				ndto = new NewsDto(bNum, title, content, uId, category, author, newsLink, enrollDate, views,
						refNum);
				ndto.setImagePathList(FileDao.getInstance().getFiles(bNum));
			}
			return ndto;
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
		return ndto;
	}

	

	public int insertNews(NewsDto ndto, List<FileDto> fList) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			query = "insert into \"F_BOARD\" values(BOARD_SEQ.nextval, ?, sysdate, 0, ?, ?, ?, BOARD_SEQ.currval)";
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, ndto.getTitle());
			pstmt.setString(2, ndto.getCont());
			pstmt.setString(3, ndto.getId());
			pstmt.setString(4, ndto.getCate());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			String newsQuery = "insert into \"NEWS\" values(BOARD_SEQ.currval, ?, ?)";
			pstmt = conn.prepareStatement(newsQuery);

			pstmt.setString(1, ndto.getAuthor());
			pstmt.setString(2, ndto.getNewsLink());
			pstmt.executeUpdate();
			
			int fileRs = FileDao.getInstance().insertFile(fList, conn);
			if(fileRs>0) {
				conn.commit();
			}

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

	public int updateNews(NewsDto ndto, List<FileDto> fList) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			query = "UPDATE \"F_BOARD\" SET \"B_TITLE\" = ? , \"B_CTGORY\" = ? ,\"B_CONTENTS\" = ? WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, ndto.getTitle());
			pstmt.setString(2, ndto.getCate());
			pstmt.setString(3, ndto.getCont());
			pstmt.setInt(4, ndto.getNum());
			
			pstmt.executeUpdate();
			System.out.println("성공1");
			pstmt.close();
			
			String newsQuery = "UPDATE \"NEWS\" SET \"AUTHOR\" = ?, \"NEWS_LINK\" = ? WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(newsQuery);

			pstmt.setString(1, ndto.getAuthor());
			pstmt.setString(2, ndto.getNewsLink());
			pstmt.setInt(3, ndto.getNum());
			pstmt.executeUpdate();
			System.out.println("성공2");
			
			int fileRs = FileDao.getInstance().updateFile(fList,ndto.getNum(), conn);
			System.out.println("성공3");
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
	
	public int delNews(int num) {
		int rs = 0;
		try {
			FileDao.getInstance().delNews(num);
			conn = getConnection();
			conn.setAutoCommit(false);
			query = "DELETE \"NEWS\" WHERE \"BOARD_NUM\" = ?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeUpdate();
			
			BoardDao.getInstance().delPost(num);
			conn.commit();
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
