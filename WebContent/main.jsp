<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     String id = (String)session.getAttribute("id");
     String name = (String)session.getAttribute("name");
     
     %>
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%=name %>님 환영합니다.</h2>
<h2><%=id %></h2>
메인화며언
<form action="/webedu/MEMBER/mLogout.jsp" method="post">
<input type="submit" value="로그아웃" />
<input type="button" value="회원정보 수정" onClick="javascript:window.location='/webedu/MEMBER/modify.jsp'"/>
</form>
</body>
</html>