<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users Info</title>
</head>
<body>
	<div align="center">
	<h2>All Users Info</h2>
	<br>
	<hr>
	<br> <br>
	
	<form action="deleteAdmin.do" method="post">
	<table border="1" >
		<tr height="40">
			<th width=50></th>
			<th width=100>Username</th>
			<th width=100>Password</th>
			<th width=100>Name</th>
			<th width=150>Contact</th>
			<th width=200>Email</th>
			<th width=200>Intended Field</th>
			<th width=200>Programming Skills</th>
			<th width=200>Major</th>
		</tr>
		
		<c:if test="${memList.size() != 0 }">
		<c:forEach var="i" begin="0" end="${memList.size()-1 }"> 
		<tr height="40">
			<th width=50><input type="checkbox" name="delMember" value="${ memList.get(i).id }"></th>
			<td align="center">${ memList.get(i).id }</td>
 			<td align="center">${ memList.get(i).pw }</td>
			<td align="center">${ memList.get(i).name }</td>
			<td align="center">${ memList.get(i).tel }</td>
			<td align="center">${ memList.get(i).email }</td>
			<td align="center">${ memList.get(i).field }</td>
			<td align="center">${ memList.get(i).skill }</td>
			<td align="center">${ memList.get(i).major }</td>
		</tr>
		</c:forEach>
		</c:if>
		
	</table>
	<br> <br>
	<input type="submit" value="Delete Selected">
	</form>
	<br> <br>
	<input type="button" value="Back Home" onclick="location.href='index.do'">
	</div>

</body>
</html>