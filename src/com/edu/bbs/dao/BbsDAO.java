package com.edu.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.edu.bbs.dto.BbsDTO;

public class BbsDAO {
	private static BbsDAO bdao = new BbsDAO();
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private BbsDAO() {}
	
	public static BbsDAO getInstance() {
		return bdao;
	}
	//글 등록
	public void write(BbsDTO bbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bid, bname, bhit, bcontent) values(?,?,?,?,?,?)");
	}
}
