<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="boardwrite" method="post" id="bfrm">
		<!-- Member -->
		<input name="id">
		<input name="email">

		<!-- Board -->
		<input name="boardTitle">
		<input name="boardContent">
		<input name="readCount" class="numberonly">
		<!-- 여러개 있다면 class로 줘서 유효성검사!! -->
		<input name="readCount1" class="numberonly">
		<input name="readCount2" class="numberonly">
		<!-- post로 간다. -->
		<input name="button" id="btnsubmit">
	</form>
	<script>
		// 유효성 검사
		// numberonly each로 숫자 변환되는지 확인하고 모두 통과하면
		bfrm.submit();
	</script>
</body>
</html>