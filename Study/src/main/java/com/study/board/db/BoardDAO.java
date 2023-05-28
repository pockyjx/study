package com.study.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	// 공통변수 선언
	private Connection con = null; // DB 연결정보 저장(관리)
	private PreparedStatement pstmt = null; // SQL 작성, 실행
	private ResultSet rs = null; // select 결과 데이터 저장
	private String sql = ""; // SQL 구문 저장
	
	// DB 연결 메서드
	private Connection getCon() throws Exception {
		
		// Context 객체 생성
		Context initCTX = new InitialContext();
		
		// DB 연결정보 불러와서 사용
		DataSource ds = (DataSource)initCTX.lookup("java:comp/env/jdbc/mvc7");
		
		// DB 연결
		con = ds.getConnection();
		System.out.println("DAO : DB연결 성공! " + con);
		
		return con;
	}
		
	// 자원해제
	public void closeDB() {
		
		try {
			if(rs  != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


		

}
