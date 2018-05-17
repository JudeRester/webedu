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
        <a href="view.do?bNum=${dto.bNum }&currpage=${pc.currpage }">${dto.bTitle }</a>
        </td>
        <td>${dto.bName }</td>
        <td>${dto.bHit }</td>
      </tr>
      </c:forEach>
      <tr>
      <td colspan="4">
		<nav aria-label="Page navigation example">
		  <ul class="pagination" >
		  	 <c:if test="${pc.pre }"> 
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=1">◀</a>
			    </li>		  	 
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=${pc.startpage-1}">◁</a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pc.startpage }" end="${pc.endpage }" var="pageNum">
		    	<c:if test="${pc.currpage == pageNum }">
			    <li class="page-item active">		
			      <a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
			    </li>
	    		 </c:if>   
	    		 <c:if test="${pc.currpage != pageNum }">
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
			    </li>
			    </c:if>
		    </c:forEach>
		    <c:if test="${pc.next }">
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=${pc.endpage+1}">▷</a>
			    </li>
			    <li class="page-item">
			    	<a class="page-link" href="list.do?currpage=${pc.lastpage}">▶</a>
			    </li>		    
		    </c:if>		    
		  </ul>
		</nav>          
      </td>
		<td colspan="5" align="">
		<a href="write_view.do?currpage=${pc.currpage }" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
		</td> 
    </tr>  
    </tbody>
    </table>
    <!-- table>
    <tr>
      <c:forEach begin="${pc.startpage }" end="${pc.endpage }" var="pageNum">
    	<c:if test="${pc.currpage == pageNum }">
	    <td class="page-item active">		
	      <a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
  	    </td>
   			 </c:if>   
   			 <c:if test="${pc.currpage != pageNum }">
	 	   <td class="page-item">
	    	<a class="page-link" href="list.do?currpage=${pageNum}">${pageNum}</a>
	 	   </td>
	 	   </c:if>
  		  </c:forEach>
  		  </tr>
  		  <tr>
  		  <td colspan="5" align="right">
     		<a href="write_view.do" class="btn btn-primary" role="button" aria-pressed="true">글쓰기</a>
     		</td>
     		</tr>
  </table-->
</div>

</body>
</html>