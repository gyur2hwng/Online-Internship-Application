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

	<div align="center">
		<h1>Sign In</h1>
		<p>In order to apply, you have to sign in first.</p>
		<hr>
		
		<form action="loginPro.do" method="post">
			
					<p >Username
					<input type="text" id="id" name="id" autofocus>
					</p>
					<p>Password
					<input type="password" id="pw" name="pw">
					</p>
				
			<div>
				<input type="submit" title="Sign In" value="Sign In">
			</div>
		</form>
		<br>
		<input type="button" value="Main Page" onclick="location.href='index.do'">
		<input type="button" value="Sign Up" onclick="location.href='join.do'">
	</div>

</body>
</html>