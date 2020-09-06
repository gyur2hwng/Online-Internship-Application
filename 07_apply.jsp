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

		<%-- cannot apply when signed out --%>
		<c:if test= "${ null eq sessionScope.memId }">
			<script type="text/javascript">
				alert('Please sign in first');
				location.href='index.do';
			</script>
		</c:if>
			
		
		<div align="center">
			<h1>Java Developers Application</h1>
			<p>We're looking for applicants who are experienced with Java, JSP, Spring.</p>
			<hr>
			
			<form action="applyPro.do" method="post">
				<h4>Applicant Info</h4>
				
						<label >Name</label>
						<input type="text" id="name" name="name" value="${ bean.name }" autofocus placeholder="Please enter without spaces">
						<br>
						<label >Contact</label>
						<input type="text" id="tel" name="tel1" value="${ tel1 }" size="3"> - 
						<input type="text" id="tel" name="tel2" value="${ tel2 }" size="4"> - 
						<input type="text" id="tel" name="tel3" value="${ tel3 }" size="4">
						<br>
						<label >Email</label>
						<input type="email" id="email" name="email" value="${ bean.email }">
				<br> <br>
				
				<hr>
				<h4>Intended Field</h4>
				
						<label>
							<input type="radio" name="field" value="publishing">Web Publishing
						</label>
					
						<label>
							<input type="radio" name="field" value="frontend">Front End
						</label>
					
						<label>
							<input type="radio" name="field" value="application">Web Application Dev
						</label>
				
				<br> <br>	
				<hr>
				<h4>Programming Skills</h4>
				
						<label>
							<input type="checkbox" name="skill" value="html">HTML
						</label>
					
						<label>
							<input type="checkbox" name="skill" value="css">CSS
						</label>
					
						<label>
							<input type="checkbox" name="skill" value="javascript">JavaScript
						</label>
				
						<label>
							<input type="checkbox" name="skill" value="java">Java
						</label>
					
						<label>
							<input type="checkbox" name="skill" value="jsp">JSP
						</label>
					
						<label>
							<input type="checkbox" name="skill" value="spring">Spring
						</label>
					
				<br> <br>
				<hr>
				<h4>Major</h4>
				
						<label >Major</label>
						<select id="major" name="major">
							<option value="computer">Computer Science</option>
							<option value="elec">Electronic Engineering</option>
							<option value="mechanic">Mechanical Engineering</option>
							<option value="indust">Industrial Engineering</option>
						</select>
					<br><br>
				<hr>
				<br>
				<div>
					<input type="submit" value="Apply">
					<input type="reset" value="Reset">
				</div>
			</form>	
		</div>

</body>
</html>