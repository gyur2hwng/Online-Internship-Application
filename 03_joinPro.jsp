<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	
		<c:if test="${ 1 eq check }">
			<script type="text/javascript">
				alert('Congratulations on being our member!');
				location.href='index.do';
			</script>
		</c:if>
			
		<c:if test="${ -1 eq check }">
			<script type="text/javascript">
				alert('Please fill out all information or same username already exists');
				history.go(-1);
			</script>
		</c:if>
	
</body>
</html>