package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {
	public static AdminDAO adminDAO = new AdminDAO();
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private AdminDAO() {
	}
	public static AdminDAO getInstance() {
		return adminDAO;
	}
//	public static void main(String args[]) { 
//		AdminDAO adao = adminDAO.getInstance(); //사용 예
//		System.out.println(adao);
//	}
//	
	
	public AdminSqlResult adminCheck(String id, String pw) {
		int n = 0;
		AdminSqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from admin where id = ?");
		try {
			conn = DataBaseUtil.getConnection();

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pw.equals(rs.getString("passwd"))) {
					sqlresult = AdminSqlResult.ADM_LOGIN_SUCCESS;
				}else {
					sqlresult = AdminSqlResult.ADM_LOGIN_PW_NOT;
				}
			}else {
				sqlresult = AdminSqlResult.ADM_LOGIN_FAILED;
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": AdminSqlResult adminCheck(String id, String pw)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return sqlresult;
	}
	public AdmDTO getAdmin(String id) {
		AdmDTO adm = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select id, passwd, name, phone, email, grade from admin where id = ?");
		try {
			conn=DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adm = new AdmDTO();
				adm.setId(rs.getString("id"));
				adm.setPasswd("passwd");
				adm.setName(rs.getString("name"));
				adm.setPhone(rs.getString("phone"));
				adm.setEmail(rs.getString("email"));
				adm.setGrade(rs.getString("grade"));
			}
		}catch(SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": MemDTO getMember(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return adm;
	}
}
