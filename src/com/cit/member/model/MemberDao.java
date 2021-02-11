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
	Connection conn = null;
	String query = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

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

	
	public MemberDto getMember(String type, String value) {
		switch(type) {
		case "id" : type = "U_ID"; break;
		case "email" : type = "U_EMAIL"; break;
		}
		
		String query = "SELECT * FROM \"USER\" WHERE "+type+" = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, value);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String u_id = rset.getString("U_ID");
				String u_pw = rset.getString("U_PW");
				String name = rset.getString("U_NAME");
				String email = rset.getString("U_EMAIL");
				String gender = rset.getString("U_GENDER");
				java.sql.Date birth = rset.getDate("U_BIRTH");
				String job = rset.getString("U_JOB");
				String path = rset.getString("JOIN_PATH");
				
				MemberDto mdto = new MemberDto(u_id, u_pw, name, email, gender, birth, job, path);
				return mdto;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return null;
	}
	
	public MemberDto searchId(String name, String email) {
		MemberDto mdto = null;
		try {
			
			conn = getConnection();
			query = "SELECT * FROM \"USER\" WHERE \"U_NAME\"=? AND \"U_EMAIL\"=?";
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
	
	public MemberDto searchPw(String name, String id, String email) {
		MemberDto mdto = null;
		
		try {
			conn = getConnection();
			query = "SELECT * FROM \"USER\" WHERE \"U_NAME\"=? AND \"U_ID\"=? AND \"U_EMAIL\"=?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return mdto;
	}
}