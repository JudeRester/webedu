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
		margin:10px; padding:10px; width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;">
<br />
  <h2>${bdto.getbTitle() }</h2>
  <p align="right" class="media-right">작성일 : ${bdto.getbCDate() }</p>
  <p align="right" class="media-right">최종수정일 : ${bdto.getbUDate() }</p>
  <hr />
  <div class="media">
    <div class="media-body">
    
    
    <p align="right" class="media-body">조회수 : ${bdto.getbHit() }</p>
	${bdto.getbNum() }<br>
	${bdto.getbName() }<br>
	${bdto.getbContent() }<br>

	</div>
</div>
</body>
</html>