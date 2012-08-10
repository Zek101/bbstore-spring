<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userlist</title>
</head>
<body>
		<table border="0" cellspacing="10">
			<tr>
				<td>Title</td>
				<td>Author</td>
				<td>ISBN</td>
				<td>Price</td>
				<td></td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.role.name}</td>
					<td>
						<form method="post" action="edituser">
							<input type="hidden" name="id" value="${user.getId()}" /> 
							<input type="submit" value="Edit" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="index">Back to menu</a>
</body>
</html>