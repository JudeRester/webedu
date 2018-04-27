<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="${bdto }" var="msg"/>
	${msg.getbNum() }
	<%-- ${a }
	${a1 }
	${a2 }
	${a3 }
	${a4 }
	${a5 }
	${a6 } --%>
</body>
</html>