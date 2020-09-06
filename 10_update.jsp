<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>

	<div align = "center">
		<h1>Edit Profile</h1>
		<p>Please check your information and application detail.</p>
		<hr>
		
		<form action="updatePro.do" method="post">
			<h4>User Info</h4>
			
					<label >Username</label>
					<input type="text" id="id" name="id" value="${ bean.id }" readonly>
				<br><br>
					<label >Password</label>
					<input type="password" id="pw" name="pw" value="${ bean.pw }">
				<br><br>
					<label >Name</label>
					<input type="text" id="name" name="name" value="${ bean.name }">
				<br><br>
					<label for="tel">Contact</label>
					<input type="text" id="tel" name="tel1" value="${ tel1 }" size="3"> - 
					<input type="text" id="tel" name="tel2" value="${ tel2 }" size="4"> - 
					<input type="text" id="tel" name="tel3" value="${ tel3 }"size="4">
				<br><br>
					<label for="email">Email</label>
					<input type="email" id="email" name="email" value="${ bean.email }">
				
			
			<h4>Intended Field</h4>
			
					<label>
						<input type="radio" name="field" value="publishing" <c:if test="${ bean.field eq 'publishing' }" > checked </c:if>> Web Publishing
					</label>
				
					<label>
						<input type="radio" name="field" value="frontend" <c:if test="${ bean.field eq 'frontend' }" > checked </c:if>> Front End
					</label>
				
					<label>
						<input type="radio" name="field" value="application" <c:if test="${ bean.field eq 'application' }" > checked </c:if>> Web Application Dev
					</label>
				
			<h4>Programming Skills</h4>
			
					<label>
						<input type="checkbox" name="skill" value="html" <c:if test="${ bean.skill eq 'html' }" > checked </c:if>>HTML
					</label>
				
					<label>
						<input type="checkbox" name="skill" value="css" <c:if test="${ bean.skill eq 'css' }" > checked </c:if>>CSS
					</label>
				
					<label>
						<input type="checkbox" name="skill" value="javascript" <c:if test="${ bean.skill eq 'javascript' }" > checked </c:if>>JavaScript
					</label>
				
					<label>
						<input type="checkbox" name="skill" value="java" <c:if test="${ bean.skill eq 'java' }" > checked </c:if>>Java
					</label>
				
					<label>
						<input type="checkbox" name="skill" value="jsp" <c:if test="${ bean.skill eq 'jsp' }" > checked </c:if>>JSP
					</label>
				
					<label>
						<input type="checkbox" name="skill" value="spring" <c:if test="${ bean.skill eq 'spring' }" > checked </c:if>>Spring
					</label>
				
			
			<h4>Major</h4>
			
					<label for="major">major</label>
					<select id="major" name="major">
						<option value="computer" <c:if test="${ bean.major eq 'computer' }">selected</c:if> >Computer Science</option>
						<option value="elec" <c:if test="${ bean.major eq 'elec' }">selected</c:if> >Electronic Engineering</option>
						<option value="mechanic" <c:if test="${ bean.major eq 'mechanic' }">selected</c:if> >Mechanical Engineering</option>
						<option value="indust" <c:if test="${ bean.major eq 'indust' }">selected</c:if> >Industrial Engineering</option>
					</select>
				<br><br>
				
			<div>
				<input type="submit" value="Edit">
				<input type="reset" value="Reset">
			</div>
		</form>	
		<br>
		<input type="button" value="Main Page" onclick="location.href='index.do'">
			
	</div>	

</body>
</html>