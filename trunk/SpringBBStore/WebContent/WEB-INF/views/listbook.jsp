<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books List</title>
</head>
<body>
	<center>
		<h1>Book list</h1>
		<br>
		<c:if test="${!edit.equals('1')}">
	${bookBasket.getList().size()} Books in the Basket<br>
		</c:if>

		<table border="0" cellspacing="10">
			<tr>
				<td>Title</td>
				<td>Author</td>
				<td>ISBN</td>
				<td>Price</td>
				<td></td>
			</tr>
			<c:forEach items="${listBook}" var="book">
				<tr>
					<td>${book.getTitle()}</td>
					<td>${book.getAuthor().getName().toUpperCase()}
						${book.getAuthor().getForname()}</td>
					<td>${book.getIsbn()}</td>
					<td>${book.getPrice()} euros</td>
					<td><c:choose>
							<c:when test="${edit.equals('1')}">
								<form method="post" action="editbook">
									<input type="hidden" name="id" value="${book.getId()}" /> 
									<input type="submit" value="Edit" />
								</form>
							</c:when>
							<c:otherwise>
								<form method="post" action="addbooktobasket">
									<input type="hidden" name="id" value="${book.getId()}" /> 
									<input type="submit" value="Buy" />
								</form>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<a href="index">Back to menu</a>
	</center>
</body>
</html>