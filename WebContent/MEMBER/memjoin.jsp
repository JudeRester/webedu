<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="js/member.js"></script>
</head>
<body>

<hr width=500 size=1>
<h2>회원가입</h2>
<hr width=500 size=1>
<form action="memberJoinOk.jsp" method="post" name="join_frm">
아이디 : <input type="email" name="id"/><br>
비밀번호 : <input type="password" name="passwd" /><br>
비밀번호 확인 : <input type="password" name="passwd_chk" /><br>
이름 : <input type="text" name="name" /><br>
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
휴대전화 : <input type="tel" name="phone" /><br>
<input type="button" value="회원가입" onClick="mem_check()"/><input type="reset" value="취소" />

</form>
</body>
</html>