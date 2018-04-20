<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	AdminDAO adao = AdminDAO.getInstance();
	AdminSqlResult sqlresult = adao.adminCheck(id, pw);
	if(sqlresult == AdminSqlResult.ADM_LOGIN_FAILED){
		//아이디 x
%>
	<script>
	window.alert("아이디가 존재하지 않습니다.");
	window.history.go(-1); //window.history.back();
	</script>
<%
	}
	else if(sqlresult == AdminSqlResult.ADM_LOGIN_PW_NOT){
		//비밀번호 틀림
%>
	<script>
	window.alert("비밀번호가 일치하지 않습니다.");
	window.history.go(-1);	
	</script>
<%
	}else if(sqlresult == AdminSqlResult.ADM_LOGIN_SUCCESS){
		AdmDTO mdto = adao.getAdmin(id);
		session.setAttribute("name", mdto.getName());
		session.setAttribute("id", mdto.getId());
		session.setAttribute("grade", mdto.getGrade());
		session.setAttribute("chkMember", "OK");
		response.sendRedirect("main.jsp");
	}
		
%>
</body>
</html>