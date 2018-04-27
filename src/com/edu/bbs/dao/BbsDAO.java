package com.edu.bbs.dao;

import java.sql.CallableStatement;
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
	CallableStatement cs;
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
		str.append("select bnum, btitle, bname, bhit, bcontent from bbs")
		.append(" order by bnum desc");
		System.out.println("1");
		
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
	/*create or replace procedure  Clist_callbbs (
		    PNUM IN OUT bbs.bnum%TYPE,
		    OTITLE OUT bbs.btitle%TYPE,
		    ONAME OUT bbs.bname%TYPE,
		    OCDATE OUT bbs.bcdate%TYPE,
		    OUDATE OUT bbs.budate%TYPE,
		    OHIT OUT bbs.bhit%TYPE,
		    OCONTENT OUT bbs.bcontent%TYPE,
		    
		    r_errcode OUT NUMBER,
		    r_errmsg OUT VARCHAR2)
		IS BEGIN
		        update BBS 
		        SET BHIT=(BHIT+1) where BNUM = PNUM;
		        select BNUM, BTITLE, BNAME, BCDATE, BUDATE, BHIT, BCONTENT
		        INTO PNUM, OTITLE, ONAME, OCDATE, OUDATE, OHIT, OCONTENT
		        FROM bbs
		        where bnum = pnum;
		        

		Exception 
		    WHEN OTHERS THEN
		    ROLLBACK;
		    r_errcode := SQLCODE;
		    r_errmsg := SQLERRM;
		    DBMS_OUTPUT.PUT_LINE('ERRCODE : ' || to_char(r_errcode));
		    DBMS_OUTPUT.PUT_LINE('ERRMSG : ' || r_errmsg);
		END Clist_callbbs;*/
	public BbsDTO view(int bNum) {
		System.out.println(bNum);
		BbsDTO bbsdto = null;
		String sql2 = "update BBS SET BHIT=(BHIT+1) where BNUM = ?";
		String sql = "select BNUM, BTITLE, BNAME, BCDATE, BUDATE, BHIT, BCONTENT FROM bbs where bnum = ?";
		try {
			conn=DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1,bNum);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("bTitle"));
				bbsdto.setbName(rs.getString("bName"));
				bbsdto.setbCDate(rs.getDate("bCdate"));
				bbsdto.setbUDate(rs.getDate("bUdate"));
				bbsdto.setbHit(rs.getInt("bHit"));
				bbsdto.setbContent(rs.getString("bContent"));
			}
		
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO view(int bNum)");
	      } finally {
	    	  System.out.println(3);
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
	      System.out.println("1");
		return bbsdto;
	}
}
