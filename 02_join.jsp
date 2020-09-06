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
<div align="center">
	
		<h1>Sign Up</h1>
		<p>Want to join IT Company?</p>
		<hr>
		
		<form action="joinPro.do" method="post">
			<h4>Sign In Info</h4>
			
					<label >Username</label>
					<input type="text" id="id" name="id">
				<br><br>
					<label >Password</label>
					<input type="password" id="pw" name="pw">
				<br>
			<h4>User Info</h4>
			
					<label >Name</label>
					<input type="text" id="name" name="name" autofocus placeholder="enter without spaces">
				<br><br>
					<label >Contact</label>
					<input type="text" id="number" name="tel1" size="3"> - 
					<input type="text" id="number" name="tel2" size="4"> - 
					<input type="text" id="number" name="tel3" size="4">
				<br><br>
					<label >Email</label>
					<input type="email" id="email" name="email">
				
			<br><br><br>
			<div>
				<input type="submit" value="Sign Up">
				<input type="reset" value="Reset">
			</div>
		</form>		
		<br>
		<input type="button" value="Main Page" onclick="location.href='index.do'">
		<input type="button" value="Sign In" onclick="location.href='login.do'">

	</div>
</body>
</html>