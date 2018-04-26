package com.edu.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.DataBaseUtil;
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
		sql.append("insert into bbs (bnum, btitle, bname, bcontent) ")
		.append("values(bbsnum_seq.nextval,?,?,?)");
		int cnt =0;
		
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			System.out.println(bbsdto.getbTitle());
			System.out.println(bbsdto.getbName());
			System.out.println(bbsdto.getbContent());
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setString(3, bbsdto.getbContent());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+":void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	public ArrayList<BbsDTO> list(){
		ArrayList<BbsDTO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		BbsDTO bbsdto = null;
		str.append("select bnum, btitle, bname, bhit, bcontent from bbs");
		
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				alist.add(bbsdto);
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+": ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return alist;
	}
}
