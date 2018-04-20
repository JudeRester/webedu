<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.edu.*" %>
     <%
     String id = (String)session.getAttribute("id");
     MemberDAO mdao = new MemberDAO();
     MemDTO mdto = mdao.getMember(id);
     %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/member.js"></script>
</head>
<body>
<hr width=500 size=1>
<h2>회원정보 수정</h2>
<hr width=500 size=1>
<form action="memModifyOK.jsp" method="post" name="modify_frm">
아이디 : <input type="email" name="id" value="<%=mdto.getId() %>" disabled = "disabled"/><br>
비밀번호 : <input type="password" name="passwd" /><br>
비밀번호 확인 : <input type="password" name="passwd_chk" /><br>
이름 : <input type="text" name="name" value="<%=mdto.getName() %>"/><br>
생년월일 : <select name="year" id="">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			</select>년
		<select name="month" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>월
		<select name="day" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>일<br>
휴대전화 : <input type="tel" name="phone" value="<%=mdto.getPhone() %>" /><br>
<input type="button" value="수정" onClick="updateInfo()"/><input type="reset" value="취소" />
<input type="button" value="탈퇴" onClick="javascript:location.href='memDelete.jsp'" />
</form>
</body>
</html>