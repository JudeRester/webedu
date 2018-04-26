<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
    <style>
    *{ margin:0;text-align:center;}
    html, body{height: 100%;margin:0;padding: 0}
    #header1 {background: rgb(5,213,245); height: 10%}
    #nav1{background-color: rgb(189,142,108); height: 10%}
    #section1{background-color: rgb(148,29,196); height: 30%; width: 70%; float: left;}
    #section2{background-color: rgb(244,229,33); width: 70%; height: 40%;float: left;}
    #article1{background-color: rgb(207,63,18); width: 30%;height: 30%; float: right;}
    #aside1{background-color: rgb(57,210,33); width:30%;height: 40%;float: right;}
    #header2{background-color: rgb(200,206,207); height: 10%}
    #footer1{background-color: rgb(92,190,15);height: 10%}
    #footer2{background-color: rgb(5,213,245);height:10%;text-align: center;}
    #p1{height: 65%;}
    </style>
</head>
<body>
<header id="header1">&lt;header&gt;</header>
<nav id="nav1">
<table>
	<td><a href="/webedu/index.jsp">홈</a></td>
	<td><a href="/webedu/MEMBER/login.jsp" target="iframe_content">로그인</a></td>
	<td><a href="/webedu/MEMBER/memjoin.jsp" target="iframe_content">회원가입</a></td>
	<td><a href="/webedu/bbs/write_view.do" target="iframe_content">게시글작성</a></td>
	<td></td>
	<td></td>
</table>
</nav>

</body>
</html>