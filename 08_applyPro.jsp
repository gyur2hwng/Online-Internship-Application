<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Application</title>
</head>
<body>

	<c:if test="${ field eq null || skill eq null || major eq null }">
		<script type="text/javascript">
			alert('Please fill out all the information');
			history.go(-1);
		</script>
	</c:if>
	
	<script type="text/javascript">
		alert('Your application has been submitted!');
		location.href='index.do';
	</script>

</body>
</html>