<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="com.edu.*" %>
      <%
     String id = (String)session.getAttribute("id");
     %>
     
   <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	MemberDAO mdao = new MemberDAO();
	int n = mdao.deleteMember(id);
	
	if(n==1){
		
    	session.invalidate(); //세션제거
	//수정 완료
	%>
	<script>
		window.alert("회원탈퇴가 완료되었습니다.");
		document.location.href="/webedu/MEMBER/login.jsp";
	</script>
	<%
	}else{
	%>
	<script>
		window.alert("회원탈퇴 실패");
		document.history(-1)</script>
	<%
		}
	%>
</body>
</html>