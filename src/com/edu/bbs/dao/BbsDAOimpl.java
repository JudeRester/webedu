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

public class BbsDAOimpl implements BbsDAO {
	private static BbsDAO bdao = new BbsDAOimpl();
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	CallableStatement cs;
	private BbsDAOimpl() {}
	
	public static BbsDAO getInstance() {
		return bdao;
	}
	//글 등록
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#write(com.edu.bbs.dto.BbsDTO)
	 */
	@Override
	public int write(BbsDTO bbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bcontent) ")
		.append("values(bbsnum_seq.nextval,?,?,?)");
		int cnt = 0;
		String sql2 ="select bbsnum_seq.currval from dual";
		int bNum= 0;
		
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setString(3, bbsdto.getbContent());
			
			cnt = pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bNum=rs.getInt("currval");
				System.out.println(bNum);
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+":void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return bNum;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#list(int, int)
	 */
	@Override
	public ArrayList<BbsDTO> list(int a, int b){
		ArrayList<BbsDTO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		BbsDTO bbsdto = null;
		str.append("select * ")
		.append("from (select rownum as rnum, bnum, btitle,bname, bhit, bcontent, bgroup, bstep, bindent ")
		.append("from (select bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent ")
		.append("from bbs ")
		.append("start with bGroup is null connect by prior bnum = bgroup ")
		.append(" order siblings by bgroup desc, bstep asc, bcdate desc, bnum desc)")
		.append(" where rownum <= ?)")
		.append(" where rnum >= ?");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(str.toString());
			pstmt.setInt(1, b);
			pstmt.setInt(2, a);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbIndent(rs.getInt("bindent"));
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
	@Override
	public ArrayList<BbsDTO> list(int a, int b, String keyword, String col){
		ArrayList<BbsDTO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		BbsDTO bbsdto = null;
		
		str.append("select * ")
		.append("from (select rownum as rnum, bnum, btitle,bname, bhit, bcontent, bgroup, bstep, bindent ")
		.append("from (select bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent ")
		.append("from bbs where");
		switch(col) {
		case "제목내용" :
			str.append("(bTitle like ? or bContent like ?)");
			break;
		case "제목" :
			str.append("(bTitle like ?)");
			break;
		case "내용" :
			str.append("(bContent like ?)");
			break;
		case "작성자" :
			str.append("(bName like ?)");
			break;
		
		}
		str.append("start with bGroup is null connect by prior bnum = bgroup ")
		.append(" order siblings by bgroup desc, bstep asc, bcdate desc, bnum desc)")
		.append(" where rownum <= ?)")
		.append(" where rnum >= ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(str.toString());
			switch(col) {
			case "제목내용" :
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
				pstmt.setInt(3, b);
				pstmt.setInt(4, a);
				break;
			default :
				pstmt.setString(1, keyword);
				pstmt.setInt(2, b);
				pstmt.setInt(3, a);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbIndent(rs.getInt("bindent"));
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
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#view(int)
	 */
	@Override
	public BbsDTO view(int bNum) {
		BbsDTO bbsdto = null;
		String sql2 = "update BBS SET BHIT=(BHIT+1) where BNUM = ?";
		String sql = "select BNUM, BTITLE, BNAME, BCDATE, BUDATE, BHIT, BCONTENT FROM bbs where bnum = ?";
		String sql3 = "select bNum from bbs where bNum=(select max(bNum) from bbs where bNum < ? and bgroup is null) ";
		String sql4 = "select bNum from bbs where bNum=(select min(bNum) from bbs where bNum > ? and bgroup is null)";
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
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bbsdto.setpPage(rs.getInt("bNum"));
			}else {
				bbsdto.setpPage(bbsdto.getbNum());
			}
			pstmt = conn.prepareStatement(sql4);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bbsdto.setnPage(rs.getInt("bNum"));
			}else {
				bbsdto.setnPage(bbsdto.getbNum());
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO view(int bNum)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
		return bbsdto;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#modify(int)
	 */
	@Override
	public BbsDTO modify(int num) {
		BbsDTO bdto = null;
		String sql = "select BNUM, BTITLE, BNAME, BCONTENT FROM bbs where bnum = ?";
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BbsDTO();
				bdto.setbNum(rs.getInt("bNum"));
				bdto.setbTitle(rs.getString("bTitle"));
				bdto.setbName(rs.getString("bName"));
				bdto.setbContent(rs.getString("bContent"));
			}
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO modify(int num)");
		}finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
		return bdto;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#modify_ac(com.edu.bbs.dto.BbsDTO)
	 */
	@Override
	public int modify_ac(BbsDTO bdto) {
		String sql = "update BBS SET btitle=?, bname=?, bcontent=?, BUDATE=sysdate where BNUM = ?";
		int cnt = 0;
		String sql2 ="select bbsnum_seq.currval from dual";
		int bNum= 0;
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getbTitle());
			pstmt.setString(2, bdto.getbName());
			pstmt.setString(3, bdto.getbContent());
			pstmt.setInt(4, bdto.getbNum());
			
			cnt = pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bNum=rs.getInt("currval");
			}
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO modify_ac(BbsDTO bdto)");
		}finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return bNum;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#delete(int)
	 */
	@Override
	public int delete(int bNum) {
		int cnt = 0;
		String sql = "delete from bbs where bNum=?";
		try {
			conn = DataBaseUtil.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"int delete(int bNum)");
		}finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return cnt;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#preinfo(int)
	 */
	@Override
	public BbsDTO preinfo(int bNum) {
		BbsDTO bbsdto = null;
		String sql = "select BNUM, BTITLE, BCONTENT, bgroup, bindent FROM bbs where bnum = ?";
		try {
			conn=DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("bTitle"));
				bbsdto.setbContent(rs.getString("bContent"));
				bbsdto.setbGroup(rs.getInt("bgroup"));
				bbsdto.setbIndent(rs.getInt("bindent"));
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO preinfo(int bNum)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
		return bbsdto;
	}
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#reply(com.edu.bbs.dto.BbsDTO)
	 */
	@Override
	public int reply(BbsDTO bbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bcontent, bgroup, bindent) ")
		.append("values(bbsnum_seq.nextval,?,?,?,?,?)");
		int cnt =0;
		String sql2 ="select bbsnum_seq.currval from dual";
		int bNum= 0;
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setString(3, bbsdto.getbContent());
			pstmt.setInt(4, bbsdto.getbGroup());
			pstmt.setInt(5, bbsdto.getbIndent());
			cnt = pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bNum=rs.getInt("currval");
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+":void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return bNum;
	}

	@Override
	public int totalrec() {
		int totalrec = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) totalrec from bbs");
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalrec = rs.getInt("totalrec");
			}
		}catch(SQLException e){
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+":int totalrec()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return totalrec;
	}
	
}
