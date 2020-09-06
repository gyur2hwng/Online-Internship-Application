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

	<c:if test="${ nodelete eq 0}">
		<script type="text/javascript">
			alert('No user(s) has(have) been selected.');
			history.go(-1);
		</script>
	</c:if>
	
	
	<c:if test="${ nodelete eq 1 }">
		<script type="text/javascript">
			alert('Selected user(s) is(are) deleted.');
			location.href='memberList.do';
		</script>
	</c:if>
	
	
</body>
</html>