<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webedu/bootstrap/dist/css/bootstrap.css">
  <script src="public/jquery/jquery-3.3.1.min.js"></script>
  <script src="/bootstrap/dist/css/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style= "border: 1px solid #ced4da; border-radius: 0.25rem;
		  width: 97%;
		  padding-up: 20px;
		  padding-down: 20px;
		  padding-right: 20px;
		  padding-left: 20px;
		  margin: 10px;">
	<br />
		<div class="media">
	  <h2 class="media-heading">${bdto.getbTitle() }</h2><br>
	  <p class="media-body"></p>
	  <p align="right" class="media-right">작성일 : ${bdto.getbCDate() }<br>최종수정일 : ${bdto.getbUDate() }
	  <br>조회수 : ${bdto.getbHit() }</p>
	  </div>
	  <hr style="margin:0px;padding-up:0px; padding-down:0px;" />
	  <div class="media">
	    <div class="media-body">
	    <p align="left" style="margin-bottom:0px;padding-up:2px;padding-down:2px">작성자 :${bdto.getbName() }</p>
	    <hr style="margin-top:0px;padding-up:0px;" />
	    <div>
		${bdto.getbContent() }<br>
		<hr />
		</div>
		</div>
	</div>
	</div>
	<div align="right" style="padding-right:20px;">
	<table>
	<tr>
		<td colspan=2 align="right">
		<a href="modify.do?bNum=${bdto.bNum }" class="btn btn-primary" role="button" aria-pressed="true">수정</a>
		<a href="delete.do?bNum=${bdto.bNum }" class="btn btn-primary" role="button" aria-pressed="true">삭제</a>
		<a href="reply.do?bNum=${bdto.bNum }" class="btn btn-primary" role="button" aria-pressed="true">답글</a>
	 	<a href="list.do" class="btn btn-primary" role="button" aria-pressed="true" aria-describedby="inputGroup-sizing-sm"> 목록으로</a>
	 	<a class="btn btn-primary" role="button" aria-pressed="true" href="view.do?bNum=${bdto.getpPage() }">◀</a>
	 	<a class="btn btn-primary" role="button" aria-pressed="true" href="view.do?bNum=${bdto.getnPage() }">▶</a>
	 	</td>
	</tr>
	</table>
	</div>
</body>
</html>