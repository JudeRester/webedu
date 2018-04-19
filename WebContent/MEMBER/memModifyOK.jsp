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
<jsp:useBean id="mdto" class ="com.edu.MemDTO"></jsp:useBean>
<jsp:setProperty property="*" name="mdto"/>
<%
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	mdto.setBirth(year+month+day);
%>

<%=mdto.getId() %>
<%=mdto.getPasswd() %>
<%=mdto.getName()%>
<%=mdto.getBirth() %>
<%=mdto.getPhone() %>


<%
	MemberDAO mdao = new MemberDAO();
	mdto.setId(id);
	int n = mdao.updateMember(mdto);
	
	if(n==1){
	//수정 완료
	%>
	<script>
		window.alert("회원정보가 수정되었습니다.");
		document.location.href="../main.jsp";
	</script>
	<%
	}else{
	%>
	<script>
		window.alert("회원정보 수정 실패");
		document.location.href="../main.jsp"</script>
	<%
		}
	%>
</body>
</html>