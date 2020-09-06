<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<div align="center">
		<h1>IT Company 2020 Internship</h1>
			<br>
			<%-- when admin signed in; admin id & pw is admin & admin, but has to sign up like that first --%>
			<c:if test="${ admin == 1}">
				Welcome, admin. <br><br>
				<a href="memberList.do">All Users Info</a><br><br><br>
				<hr>
				<br><br>
				<a href="logout.do">Sign Out</a>
			</c:if>
			
			<%-- When applicant signed in --%>
			<c:if test="${ null ne id && admin != 1 }">
				Welcome, ${ id }.<br><br>
				<a href="logout.do">Sign Out</a><br><br>
				<a href="update.do">Edit Profile</a><br><br>
				<a href="delete.do">Delete Account</a><br><br>
				<br><br><br>
				<hr>
				<br><br><br>
				<a href="apply.do"><img alt="Apply Online" src="apply.png"></a>
			</c:if>
			
			<%-- Sign Out status --%>
			<c:if test="${ null eq id }">
				<a href="join.do">Sign Up</a><br><br>
				<a href="login.do">Sign In</a><br><br>
				<br><br><br>
				<hr>
				<br><br><br>
				<a href="apply.do"><img alt="Apply Online" src="apply.png"></a>
			</c:if>
			
				
		</div> 

</body>
</html>

<%--

<Resource 
	auth="Container" 
	driverClassName="com.mysql.cj.jdbc.Driver"
	loginTimeout="10" 
	maxWait="5000" 
	name="jdbc/pool" 
	username="root"
	password="root" 
	type="javax.sql.DataSource"
	url="jdbc:mysql://localhost:3306/joinmvcdb04?serverTimezone=UTC" 
	
/>

--%>