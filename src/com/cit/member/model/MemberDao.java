package com.cit.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class MemberDao {

	private static MemberDao instance;
    private MemberDao(){}
    public static MemberDao getInstance(){
        if(instance==null)
            instance=new MemberDao();
        return instance;
    }
    
    private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/pool01");
		return ds.getConnection();
	}

	public int insert(MemberDto mDto) {
		Connection conn = null;
		String query = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","CIT","CITPASS");
			query ="INSERT INTO \"USER\" VALUES (?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPw());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getEmail());
			pstmt.setString(5, mDto.getGender());
			pstmt.setDate(6, mDto.getBirth());
			pstmt.setString(7, mDto.getJob());	
			pstmt.setString(8, mDto.getPath());
			pstmt.setInt(9, 0);
			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	
	public MemberDto getMember() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
//			con = 
		}catch(Exception e) {
			
		}finally {
			
		}
		
		return null;
		
	}
	
	public MemberDto searchId(String name, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDto mdto = null;
		try {
			
			conn = getConnection();
			String query = "SELECT * FROM \"USER\" WHERE \"U_NAME\"=? AND \"U_EMAIL\"=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				mdto = new MemberDto(
					rset.getString("U_ID"),
					rset.getString("U_PW"),
					rset.getString("U_NAME"),
					rset.getString("U_EMAIL"),
					rset.getString("U_GENDER"),
					rset.getDate("U_BIRTH"),
					rset.getString("U_JOB"),
					rset.getString("JOIN_PATH")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return mdto;
	}
}