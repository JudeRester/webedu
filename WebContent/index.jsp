<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="main_top.jsp" />
<%-- <jsp:include page="MEMBER/login.jsp" />--%>
<iframe src="MEMBER/login.jsp" name="iframe_content" width=100%; height=70%; style= border:none;></iframe>
<%--
<jsp:include page="main_right_up.jsp" />
<jsp:include page="main_right_down.jsp" />
--%>
<jsp:include page="main_bottom.jsp" />
</body>
</html>