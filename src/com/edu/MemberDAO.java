package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	public MemberDAO() {
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
}
