package com.javateam.project.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javateam.project.entity.MemberDto;
import com.javateam.project.member.controller.joinController;

public class MemberDao {
	
	// 싱글톤 패턴
	private static MemberDao instance;
    private MemberDao(){}
    public static MemberDao getInstance(){
        if(instance==null)
            instance=new MemberDao();
        return instance;
    }
	
    // 회원가입 : DM에 회원정보 넣기
	public int insert(MemberDto mDto) {
		
		Connection conn = null;
		String query = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","PROJECT","CIT");
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
			System.out.println("연결 오류");
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
	
}
