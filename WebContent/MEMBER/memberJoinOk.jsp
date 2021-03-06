<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.edu.*" %>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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

<C:set var="birth" value="${param.year}${param.month}${param.day }" />
${mdto.setBirth(birth) }

${mdto.getId() }
${mdto.getPasswd() }
${mdto.getName() }
${mdto.getBirth() }
${mdto.getPhone() }

<%
	MemberDAO mdao = MemberDAO.getInstance();
	
	SqlResult sqlresult = mdao.checkId(mdto.getId());
	SqlResult sqlresult2 = mdao.insertMember(mdto);

		%>
	<C:choose>
	<C:when test="${sqlresult == SqlResult.MEM_EXIST}">
	<script>
	window.alert("아이디가 이미 존재합니다.");
	document.location.href="memjoin.jsp";

	</script>
	</C:when>
	<C:when test="${sqlresult2==SqlResult.MEM_JOIN_SUCCESS}">
	<script>
				window.alert("회원가입 처리되었습니다.");
				document.location.href="login.jsp";
			</script>
	</C:when>	
	<C:when test="${sqlresult2!=SqlResult.MEM_JOIN_SUCCESS && sqlresult != SqlResult.MEM_EXIST}">
	<script>
		window.alert("회원가입이 실패하였습니다");
		<!--document.location.href="memjoin.jsp";-->
		</script>
	</C:when>
	</C:choose>
	

</body>
</html>