package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	
	public static MemberDAO mdao = new MemberDAO();
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private MemberDAO() {
	}
	public static MemberDAO getInstance(){
		return mdao;
	}
	public SqlResult insertMember(MemDTO member) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		SqlResult sqlresult = null;

		sql.append("insert into member ")
			.append("(id, passwd, name, birth, phone) ")
			.append("values (?,?,?,?,?)");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getPhone());
			
			cnt = pstmt.executeUpdate();
			sqlresult = SqlResult.MEM_JOIN_SUCCESS;
		}catch (SQLException e) {
			e.printStackTrace();
			DataBaseUtil.printSQLException(e,
					this.getClass().getName()+
					": int insertMember(MemDTO member)");
		}finally {
			DataBaseUtil.close(conn, pstmt, rs);
			
		}
		return sqlresult;
	}

	public SqlResult checkId(String id) {
		String sql = "select id from member where id = ?";
		SqlResult sqlresult = null;
		try {
			conn = DataBaseUtil.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sqlresult = SqlResult.MEM_EXIST;
			}else {
				sqlresult = SqlResult.MEM_NONEXIST;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": int checkId(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		
		return sqlresult;
	}
	public SqlResult memberCheck(String id, String pw) {
		int n = 0;
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from member where id = ?");
		try {
			conn = DataBaseUtil.getConnection();

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pw.equals(rs.getString("passwd"))) {
					sqlresult = SqlResult.MEM_LOGIN_SUCCESS;
				}else {
					sqlresult = SqlResult.MEM_LOGIN_PW_NOT;
				}
			}else {
				sqlresult = SqlResult.MEM_LOGIN_FAILED;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": SqlResult memberCheck(String id, String pw)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return sqlresult;
	}
	public MemDTO getMember(String id) {
		MemDTO member = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select id, passwd, name, birth,phone from member where id = ?");
		try {
			conn=DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemDTO();
				member.setId(rs.getString("id"));
				member.setPasswd("passwd");
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setPhone(rs.getString("phone"));
			}
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": MemDTO getMember(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return member;
	}
	public int updateMember(MemDTO member) {
		int n=0;
		StringBuffer sql = new StringBuffer();
		sql.append("update member set passwd=?, name=?,phone=? where id = ?");
		try {
			conn=DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getId());

			n = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": int updateMember(MemDTO member)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int deleteMember(String id) {
		int n = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member where id = ?");
		try {
			conn=DataBaseUtil.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			n=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": int deleteMember(String id)");
		}finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return n;
	}
}
