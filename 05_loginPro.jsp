<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>

		<c:if test="${ 1 eq check }">
			<script type="text/javascript">
				alert('Welcome, ${sessionScope.memId}!');
				location.href='index.do';
			</script>
		</c:if>
	
		<c:if test="${ -1 eq check }">
			<script type="text/javascript">
				alert('Please check your username and password');
				history.go(-1);
			</script>
		</c:if>
	
		
		
</body>
</html>