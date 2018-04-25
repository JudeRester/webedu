<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		String str = c.getName();
		out.println(c.getName()+"\n"+c.getValue());
		out.println("<br>");
	}
	%>
	
	<a href="cookie03.jsp">쿠키삭제</a>
</body>
</html>