<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// ${pageContext.request.contextPath}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>boardlist 출력</title>
</head>
<body>

	${volist }
	<br>
	<!-- get 방식으로 이동  -->
	<a href="boardwrite">글쓰기</a> 
	
</body>
</html>