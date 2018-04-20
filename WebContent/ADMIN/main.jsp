<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     String id = (String)session.getAttribute("id");
     String name = (String)session.getAttribute("name");
     String grade = (String)session.getAttribute("grade");
     %>
         <%
    if(session.getAttribute("chkMember")==null){
   	 	%>
    	<jsp:forward page="login.jsp" />
    	
    	<%
    	}
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
<h2><%=grade %>급 관리자</h2>
메인화며언
<form action="aLogout.jsp" method="post">
<input type="submit" value="로그아웃" />
<input type="button" value="회원정보 수정" onClick="javascript:window.location='modify.jsp'"/>
</form>

</body>
</html>