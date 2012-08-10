<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book store</title>
</head>
<body>
	<center>
		<h1>Book Store Menu</h1>
		<table>
			<tr>
				<td valign="top">
					<center>
						<h2>Managment</h2>

					</center>
					<ul>
						<li><a href="viewlist?edit=true">Edit book</a></li>
						<li><a href="createbook">Add new book</a></li>
						<li><a href="createAuthor">Add new author</a></li>
					</ul>
				</td>
				<td valign="top">
					<center>
						<h2>Shop</h2>

					</center>
					<ul>
						<li><a href="viewlist?edit=false">View Books list</a></li>
						<c:choose>
							<c:when test="${shoppingBasket.getList().size()>0}">

								<li><a href="viewshoppingcart">View Shopping Basket</a></li>
							</c:when>
							<c:otherwise>
								<li><i>View Shopping Basket</i></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<center>
						<h2>admin</h2>
					</center>
					<ul>
						<li><a href="addUser">add user</a></li>
					</ul>
				</td>
			</tr>
		</table>
	</center>
</html>