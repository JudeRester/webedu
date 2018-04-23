<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="js/admin.js"></script>
</head>
<body>

<hr width=500 size=1>
<h2>회원가입</h2>
<hr width=500 size=1>
<form action="aJoinOk.jsp" method="post" name="join_frm">
아이디 : <input type="email" name="id" id='id'/><br>
비밀번호 : <input type="password" name="passwd" id='passwd' /><br>
비밀번호 확인 : <input type="password" name="passwd_chk" id='passwd_chk' /><br>
이름 : <input type="text" name="name" /><br>
휴대전화 : <input type="tel" name="phone" id=phone /><br>
이메일 : <input type="email" name=email id=email/><br>
<input type="button" value="관리자등록" <%--onClick="mem_check()"--%>/><input type="reset" value="취소" />

</form>
</body>
</html>
