<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Basket</title>
</head>
<body>
	<center>
		<h1>Your basket</h1><br>
		${bookBasket.getList().size()} Books in the Basket<br>
		<table>
			<c:forEach items="${bookBasket.getList()}" var="book">
				<tr>
					<td>${book.getTitle()}</td>
					<td>${book.getPrice()} euros</td>
					<td>
						<form method="post" action="removefrombasket">
							<input type="hidden" name="bookId" value="${book.getId()}">
							<input type="submit" value="Remove">
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td><b>Total: </b></td>
				<td><b>${bookBasket.getTotal()} euros</b></td>
				<td></td>
			</tr>
		</table>
		<a href="index">Back to menu</a>
	</center>
</body>
</html>