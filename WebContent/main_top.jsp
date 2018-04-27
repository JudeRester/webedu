<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="/webedu/bootstrap/dist/css/bootstrap.css">
  <script src="public/jquery/jquery-3.3.1.min.js"></script>
  <script src="/bootstrap/dist/css/bootstrap.js"></script>
  <title>Document</title>
    <style>
    *{ margin:0;text-align:center;}
    html, body{height: 100%;margin:0;padding: 0}
    #header1 {background: rgb(5,213,245); height: 10%}
    .nav1{background-color: #333; height: 10%; overflow: hidden;}
    .nav1 a {
  float: left;
  color: #f2f2f2;
  text-align: center;
    padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.nav1 a:hover {
  background-color: #ddd;
  color: black;
}

.nav1 a.active {
  background-color: #4CAF50;
  color: white;
}
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
<nav class="nav1">
	<a href="/webedu/index.jsp">홈</a>
	<a href="/webedu/MEMBER/login.jsp" target="iframe_content">로그인</a>
	<a href="/webedu/MEMBER/memjoin.jsp" target="iframe_content">회원가입</a>
	<a href="/webedu/bbs/list.do" target="iframe_content">게시판</a>
	<!-- <form class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form> -->
</nav>

</body>
</html>