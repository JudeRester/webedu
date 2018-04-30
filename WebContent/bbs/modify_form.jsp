<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<table class="table table-hover">
	<form action="/webedu/bbs/modify_ac.do?bNum=${bNum }">
		<tr>
			<th scope="col" class="w-25 p-3">제목</th>
			<td scope="col"><input type="text" name="bTitle" class="form-control" id="" placeholder="insert title" value="${bdto.getbTitle() }"/></td>
		</tr>
		<tr>
			<th scope="col">작성자</th>
			<td scope="col"><input type="text" name="bName" class="form-control" id="" placeholder="insert your name" value="${bdto.getbName() }"/></td>
		</tr>
		<tr>
			<th scope="col">내용</th>
			<td scope="col"><textarea class="form-control" name="bContent" id="" >${bdto.getbContent() }</textarea></td>
		</tr>
		<tr>
			<td colspan=2>
			<input type="submit" class="btn btn-primary" value="등록" />
		 	<a href="list.do" class="btn btn-primary" role="button" aria-pressed="true" aria-describedby="inputGroup-sizing-sm"> 목록으로</a>
		</tr>
	</form>
</table>
</body>
</html>