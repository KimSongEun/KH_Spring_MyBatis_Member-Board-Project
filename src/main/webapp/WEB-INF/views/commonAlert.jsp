<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
</head>
<body>
	${msg }
	<!-- 5초 후 자동 페이지 이동. url로 지정된 곳으로 이동 -->
	<script>
		location.href="${pageContext.request.contextPath}/${url}"
	</script>
</body>
</html>