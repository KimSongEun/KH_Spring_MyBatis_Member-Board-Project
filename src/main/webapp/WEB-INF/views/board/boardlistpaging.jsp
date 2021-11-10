<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardlisting 출력</title>
</head>
<body>
	<h1>게시판</h1>
	
	<p>페이지</p>
	<c:forEach begin="${startPage }" end="${endPage }" step="1" var="i">
		<c:if test="${currentPage == i}">
			<strong>
		</c:if>
		<a href="boardlistpaging?page=${i}">${i }</a> 
		<c:if test="${currentPage == i}">
			</strong>
		</c:if>
	</c:forEach>
	
	
	<table>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
		</tr>
		<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.boardNum }</td>
			<td>${vo.boardTitle }</td>
			<td>${vo.boardWriter }</td>
			<td>${vo.date }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>