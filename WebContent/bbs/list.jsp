<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script -->
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webedu/bootstrap/dist/css/bootstrap.css">
  <script src="public/jquery/jquery-3.3.1.min.js"></script>
  <script src="/bootstrap/dist/css/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <table class="table table-hover">
   		 <thead class ="thead-light">
      <tr>
        <th scope="col">글번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
      </tr>
    </thead>
    <tbody>
   		<c:forEach items="${list }" var="dto">
      <tr>
      	<th scope="row">${dto.bNum }</th>
        <td>
        <c:forEach begin="1" end="${dto.bIndent }">┗</c:forEach>
        <a href="view.do?bNum=${dto.bNum }">${dto.bTitle }</a>
        </td>
        <td>${dto.bName }</td>
        <td>${dto.bHit }</td>
      </tr>
      </c:forEach>
     	<tr>
     		<td colspan="5" align="right">
     		<a href="write_view.do" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
     		</td>
     	</tr>
    </tbody>
  </table>
</div>

</body>
</html>