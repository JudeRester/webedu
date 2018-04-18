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
<%request.setCharacterEncoding("UTF-8"); %>
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
	
	SqlResult sqlresult = mdao.checkId(mdto.getId());
	if(sqlresult == SqlResult.MEM_EXIST){
		%>
	<script>
	window.alert("아이디가 이미 존재합니다.");
	document.location.href="memjoin.jsp";

	</script>	
<%
	}else{
		if(mdao.insertMember(mdto)==SqlResult.MEM_JOIN_SUCCESS){
	%>
			<script>
				window.alert("회원가입 처리되었습니다.");
				document.location.href="login.jsp";
			</script>
	<%
		}else{
	%>
		<script>
		window.alert("회원가입이 실패하였습니다");
		document.location.href="memjoin.jsp";
		</script>
		<%	
		}
	}
%>
</body>
</html>