<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- request 객체 : 사용자(클라이언트)의 요청을 관리하는 객체
		<메소드>
		getContextPath() : 웹 어플리케이션의 컨텍스트 패스를 얻어올 때 사용하는 메소드
		getMethod() : get방식과 post방식을 구분하기 위해서 사용하는 메소드
		getSession() : 세션 객체를 얻을 때 사용하는 메소드
		getProtocol() : 해당 프로토콜을 얻어올 때 사용하는 메소드
		getRequesetURL() : 요청한 URL을 얻어올 때 사용하는 메소드
		getRequestURI() : 요청 URI를 얻어올 때 사용하는 메소드
		getQueryString() : 쿼리 스트링을 얻을때 사용하는 메소드
 -->
	<%
		out.print("서버 : " + request.getServerName()+"<br>");
		out.print("포트 : " + request.getServerPort()+"<br>");
		out.print("요청방식 : " + request.getMethod()+"<br>");
		out.print("프로토콜 : " + request.getProtocol()+"<br>");
		out.print("URL : " + request.getRequestURL()+"<br>");
		out.print("URI : " + request.getRequestURI()+"<br>");
		%>
		
<!--
	request 객체 관련 메소드(파라미터 메소드)
	getParameter(String name) : name에 해당하는 파라미터의 값을 구할 때 사용
	getParameterNames() : 모든 파라미터의 이름을 얻어 올 때 사용
	getParameterValues(String name) : name에 해당하는 파라미터의 값을 얻어 올 수 있다.(반환타입은 배열)
 -->
 
 <% 
 String name, id, pw, gender, local;
 String[] hobbys;
 %>
 
 <%
 request.setCharacterEncoding("UTF-8");
 name = request.getParameter("name");
 id = request.getParameter("id");
 pw = request.getParameter("pw");
 gender = request.getParameter("gender");
 local = request.getParameter("local");
 hobbys = request.getParameterValues("hobbys");
 %>
 <hr>
 이름 : <%=name %><br>
 아이디 :<%=id %><br>
 비밀번호 : <%=pw %><br>
 성별 : <%=gender %><br>
 지역 : <%=local %><br>
 취미 : <%=Arrays.toString(hobbys) %>
 
</body>
</html>